package com.banquito.corepasivos.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.model.ClientAddress;
import com.banquito.corepasivos.client.model.ClientAddressPK;
import com.banquito.corepasivos.client.repository.ClientAddressRepository;

@Service
public class ClientAddressService {
    private final ClientAddressRepository clientAddressRepository;

    public ClientAddressService(ClientAddressRepository clientAddressRepository) {
        this.clientAddressRepository = clientAddressRepository;
    }

    public List<ClientAddress> findAllClientAddresses() {
        return clientAddressRepository.findAll();
    }

    public List<ClientAddress> findAllClientAddressesByIdentification(String identification) {
        return clientAddressRepository.findByPkIdentification(identification);
    }

    @Transactional
    public void createClientAddress(ClientAddress clientAddress) {
        try {
            this.clientAddressRepository.save(clientAddress);
        } catch (Exception e) {
            throw new RuntimeException("The address is already linked to the user");
        }
    }

    @Transactional
    public void updateClientAddress(ClientAddress clientAddress) {
        if (!this.clientAddressRepository.existsById(clientAddress.getPk()))
            throw new RuntimeException("Address not found");
        else
            try {
                this.clientAddressRepository.save(clientAddress);
            } catch (Exception e) {
                throw new RuntimeException("Something went wrong");
            }
    }

    @Transactional
    public void deleteClientAdress(ClientAddress clientAddress) {
        if (!this.clientAddressRepository.existsById(clientAddress.getPk()))
            throw new RuntimeException("Address not found");
        else
            try {
                this.clientAddressRepository.delete(clientAddress);
            } catch (Exception e) {
                throw new RuntimeException("Something went wrong");
            }
    }

    @Transactional
    public void deleteClientAdress(ClientAddressPK pk) {
        if (!this.clientAddressRepository.existsById(pk))
            throw new RuntimeException("Address not found");
        else
            try {
                this.clientAddressRepository.deleteById(pk);
            } catch (Exception e) {
                throw new RuntimeException("Something went wrong");
            }
    }
}
