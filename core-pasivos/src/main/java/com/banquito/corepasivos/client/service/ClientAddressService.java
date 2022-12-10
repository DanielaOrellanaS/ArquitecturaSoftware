package com.banquito.corepasivos.client.service;

import java.util.List;
import java.util.Optional;

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

    public List<ClientAddress> findAddressByClientId(String id, String type) {
        try {
            List<ClientAddress> addresses = clientAddressRepository
                    .findByPkIdentificationAndPkIdentificationtype(id, type);
            if (!addresses.isEmpty())
                return addresses;
            else
                throw new RuntimeException("Address not found");
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void createClientAddress(ClientAddress clientAddress) {
        try {
            Optional<ClientAddress> optional = this.clientAddressRepository.findById(clientAddress.getPk());
            if (optional.isPresent()) {
                throw new RuntimeException("The address is already linked to the user");
            } else {
                this.clientAddressRepository.save(clientAddress);
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void updateClientAddress(ClientAddressPK pk, ClientAddress clientAddress) {
        try {

            if (!this.clientAddressRepository.existsById(pk))
                throw new RuntimeException("Address not found");
            else
                try {
                    this.clientAddressRepository.save(clientAddress);
                } catch (Exception e) {
                    throw new RuntimeException("Something went wrong");
                }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional
    public void deleteClientAddress(ClientAddressPK pk) {
        try {
            if (!this.clientAddressRepository.existsById(pk))
                throw new RuntimeException("Address not found");
            else
                try {
                    this.clientAddressRepository.deleteById(pk);
                } catch (Exception e) {
                    throw new RuntimeException("Something went wrong");
                }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
