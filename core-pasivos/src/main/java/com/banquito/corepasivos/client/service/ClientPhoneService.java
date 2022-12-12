package com.banquito.corepasivos.client.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.model.ClientPhonePK;
import com.banquito.corepasivos.client.repository.ClientPhoneRepository;
import com.banquito.corepasivos.utils.Validations;

@Service
public class ClientPhoneService {
    private final ClientPhoneRepository clientPhoneRepository;

    public ClientPhoneService(ClientPhoneRepository clientPhoneRepository) {
        this.clientPhoneRepository = clientPhoneRepository;
    }

    public List<ClientPhone> findByIdentification(String identification, String identificationType) {
        try {
            List<ClientPhone> phonesByIdentificationClient = this.clientPhoneRepository
                    .findByPkIdentificationAndPkIdentificationtype(identification, identificationType);
            if (phonesByIdentificationClient.isEmpty())
                throw new RuntimeException("Phone of: " + identification + " not found.");
            return phonesByIdentificationClient;
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void createPhone(ClientPhone phone) {
        if (phone.getPk().getPhonenumber().length() > 16
                || phone.getPk().getPhonenumber().length() <= 0)
            throw new RuntimeException("The phone: " + phone.getPk().getPhonenumber() + " is too long.");

        try {
            if (!Validations.validateIdentificationByType(phone.getPk().getIdentification(),
                    phone.getPk().getIdentificationtype()))
                throw new RuntimeException(
                        "The identification:" + phone.getPk().getIdentification() + " is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "The identification:" + phone.getPk().getIdentification() + " is incorrect");
        }
        this.clientPhoneRepository.save(phone);
    }

    @Transactional
    public ClientPhone updateById(String identification, String identificationType, 
                                String phone, ClientPhone clientPhone) throws Exception {

        ClientPhonePK pk = new ClientPhonePK();
        pk.setIdentification(identification);
        pk.setIdentificationtype(identificationType.toUpperCase());
        pk.setPhonenumber(phone);

        Optional<ClientPhone> currentClientPhone = this.clientPhoneRepository.findById(pk);

        try {
            if (currentClientPhone.isPresent())
                throw new RuntimeException("Phone of: " + identification + " not found.");

            if (!clientPhone.getPk().getIdentification().equals(identification))
                throw new RuntimeException("Identification searching isn't equal to : " + clientPhone.getPk().getIdentification());

            if (clientPhone.getPk().getPhonenumber().length() > 16
                    || clientPhone.getPk().getPhonenumber().length() <= 0)
                throw new RuntimeException("The phone: " + clientPhone.getPk().getPhonenumber() + " is too long.");

            if (!Validations.validateIdentificationByType(identification,
                clientPhone.getPk().getIdentificationtype()))
                throw new RuntimeException(
                        "The identification:" + clientPhone.getPk().getIdentification() + " is incorrect");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClientPhone oldClientPhone = currentClientPhone.get();
        this.clientPhoneRepository.delete(oldClientPhone);
        return this.clientPhoneRepository.save(clientPhone);

    }

    @Transactional
    public void deleteById(String identification, String identificationType, 
    String phone) throws Exception {

    ClientPhonePK pk = new ClientPhonePK();
    pk.setIdentification(identification);
    pk.setIdentificationtype(identificationType.toUpperCase());
    pk.setPhonenumber(phone);

    Optional<ClientPhone> currentClientPhone = this.clientPhoneRepository.findById(pk);

        if (!currentClientPhone.isPresent())
            throw new RuntimeException(
                    "Phone of: " + pk.getIdentification() + " not found.");

        ClientPhone phoneClient = currentClientPhone.get();
        this.clientPhoneRepository.delete(phoneClient);
    }

    @Transactional
    public void deletePhones(String identification, String identificationType) {
        try {
            this.clientPhoneRepository.deleteByPkIdentificationAndPkIdentificationtype(identification, identificationType);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
