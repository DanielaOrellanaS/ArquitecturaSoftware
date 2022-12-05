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
            throw new RuntimeException("Ya existe una direccion creada con dichos parametros");
        }
    }

    @Transactional
    public void updateClientAddress(ClientAddress clientAddress) {
        Optional<ClientAddress> auxAddress = this.clientAddressRepository.findById(clientAddress.getPk());
        if (auxAddress.isPresent())
            throw new RuntimeException("No se ha encontrado la direcciona asociada al usuario");
        else
            try {
                this.clientAddressRepository.save(clientAddress);
            } catch (Exception e) {
                throw new RuntimeException("Ha ocurrido un error en la actualizacion de datos");
            }
    }

    @Transactional
    public void deleteClientAdress(ClientAddress clientAddress) {
        Optional<ClientAddress> auxAddress = this.clientAddressRepository.findById(clientAddress.getPk());
        if (auxAddress.isPresent())
            throw new RuntimeException("No se ha encontrado la direcciona asociada al usuario");
        else
            try {
                this.clientAddressRepository.delete(clientAddress);
            } catch (Exception e) {
                throw new RuntimeException("Ha ocurrido un error en la eliminacion de la direccion");
            }
    }

    @Transactional
    public void deleteClientAdress(ClientAddressPK pk) {
        Optional<ClientAddress> auxAddress = this.clientAddressRepository.findById(pk);
        if (auxAddress.isPresent())
            throw new RuntimeException("No se ha encontrado la direcciona asociada al usuario");
        else
            try {
                this.clientAddressRepository.deleteById(pk);
            } catch (Exception e) {
                throw new RuntimeException("Ha ocurrido un error en la eliminacion de la direccion");
            }
    }
}
