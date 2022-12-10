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

    public List<ClientPhone> findByClient(String id, String type) {
        try {
            List<ClientPhone> phonesByIdentificationClient = this.clientPhoneRepository
                    .findByPkIdentificationAndPkIdentificationtype(id, type);
            if (phonesByIdentificationClient.isEmpty())
                throw new RuntimeException("Phone of: " + id + " not found.");
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
    public void updateById(ClientPhonePK pk, ClientPhone phone) {
        Optional<ClientPhone> optional = this.clientPhoneRepository.findById(pk);
        if (!optional.isPresent())
            throw new RuntimeException("Phone of: " + pk.getIdentification() + " not found.");

        if (phone.getPk().getPhonenumber().length() > 16
                || phone.getPk().getPhonenumber().length() <= 0)
            throw new RuntimeException("The phone: " + phone.getPk().getPhonenumber() + " is too long.");

        try {
            if (!Validations.validateIdentificationByType(pk.getIdentification(),
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
    public void deleteById(ClientPhonePK pk) {
        Optional<ClientPhone> phone = this.clientPhoneRepository.findById(pk);

        if (!phone.isPresent())
            throw new RuntimeException(
                    "Phone of: " + pk.getIdentification() + " not found.");

        ClientPhone phoneClient = phone.get();
        this.clientPhoneRepository.delete(phoneClient);
    }

    @Transactional
    public void deletePhones(String id, String type) {
        try {
            this.clientPhoneRepository.deleteByPkIdentificationAndPkIdentificationtype(id, type);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
