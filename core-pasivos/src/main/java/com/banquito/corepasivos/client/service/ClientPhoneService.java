package com.banquito.corepasivos.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.repository.ClientPhoneRepository;
import com.banquito.corepasivos.client.utils.Validations;

@Service
public class ClientPhoneService {
    private final ClientPhoneRepository clientPhoneRepository;

    public ClientPhoneService(ClientPhoneRepository clientPhoneRepository) {
        this.clientPhoneRepository = clientPhoneRepository;
    }

    @Transactional
    public ClientPhone save(ClientPhone newclientPhone) {
        if(newclientPhone.getPk().getPhonenumber().length() > 16 || newclientPhone.getPk().getPhonenumber().length() <= 0 )
            throw new RuntimeException("The phone: " + newclientPhone.getPk().getPhonenumber() + " is too long.");

        if(Validations.validateIdentificationByType(newclientPhone.getPk().getIdentification(), newclientPhone.getPk().getIdentificationType()))
            throw new RuntimeException("The identification:" + newclientPhone.getPk().getIdentification() + " is incorrect");
        return this.clientPhoneRepository.save(newclientPhone);
    }

    public List<ClientPhone> findAll() {
        List<ClientPhone> clientPhone = this.clientPhoneRepository.findAll();

        if (clientPhone.isEmpty())
            throw new RuntimeException("Client phones not found.");

        return clientPhone;
    }

    public List<ClientPhone> findByIdentificationClient(String identification) {
        List<ClientPhone> phonesByIdentificationClient = this.clientPhoneRepository.findByPkIdentificationEquals(identification);

        if (phonesByIdentificationClient.isEmpty())
            throw new RuntimeException("Phone of: " + identification + " not found.");

        return phonesByIdentificationClient;
    }

    @Transactional
    public ClientPhone updateByIdentificationClient(String identification, ClientPhone newclientPhone) {
        List<ClientPhone> phonesByIdentificationClient = this.clientPhoneRepository.findByPkIdentificationEquals(identification);

        if (phonesByIdentificationClient.isEmpty())
            throw new RuntimeException("Phone of: " + identification + " not found.");

        if(newclientPhone.getPk().getPhonenumber().length() > 16 || newclientPhone.getPk().getPhonenumber().length() <= 0 )
            throw new RuntimeException("The phone: " + newclientPhone.getPk().getPhonenumber() + " is too long.");

        if(Validations.validateIdentificationByType(identification, newclientPhone.getPk().getIdentificationType()))
            throw new RuntimeException("The identification:" + newclientPhone.getPk().getIdentification() + " is incorrect");

        return this.clientPhoneRepository.save(newclientPhone);
    }

    @Transactional
    public ClientPhone deleteByIdentificationClient(String identification) {
        List<ClientPhone> phonesByIdentificationClient = this.clientPhoneRepository.findByPkIdentificationEquals(identification);

        if (phonesByIdentificationClient.isEmpty())
            throw new RuntimeException(
                    "Phone of: " + identification + " not found.");

        ClientPhone phoneClient = phonesByIdentificationClient.get(0);
        this.clientPhoneRepository.delete(phoneClient);
        return phoneClient;
    }

}
