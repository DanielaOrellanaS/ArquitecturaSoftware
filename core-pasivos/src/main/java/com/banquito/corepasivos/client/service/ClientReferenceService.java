package com.banquito.corepasivos.client.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.client.model.ClientReference;
import com.banquito.corepasivos.client.repository.ClientReferenceRepository;

@Service
public class ClientReferenceService {
    private final ClientReferenceRepository clientReferenceRepo;

    public ClientReferenceService(ClientReferenceRepository clientReferenceRepo) {
        this.clientReferenceRepo = clientReferenceRepo;
    }

    public List<ClientReference> findAllClientReference (String id){
        return this.clientReferenceRepo.findByIdentification(id);
    }

    @Transactional // 1
    public void saveClientReference(ClientReference client){
        if (client.getCodeReference() != null){
            Optional<ClientReference> clientOpt = this.clientReferenceRepo.findById(client.getCodeReference());
            if (clientOpt.isPresent()){
                throw new RuntimeException("Cant insert that referece, client already registered");
            }
        }
        this.clientReferenceRepo.save(client);
    }

    @Transactional
    public void updateClientReference(ClientReference client) {
        if (client.getCodeReference() != null){
            Optional<ClientReference> clientOpt = this.clientReferenceRepo.findById(client.getCodeReference());
            if (!clientOpt.isPresent())
                throw new RuntimeException("Client reference not found");
            else {
                try {
                    this.clientReferenceRepo.save(client);
                } catch (Exception e) {
                    throw new RuntimeException("Data update error");
                }
            }
        }else throw new RuntimeException("Code reference can't be null");
    }

    @Transactional
    public void deleteClientReference(Integer codeReference){
        if (codeReference == null){
            throw new RuntimeException("Code reference can't be null");
        }else {
            Optional<ClientReference> clientOpt = this.clientReferenceRepo.findById(codeReference);
            if (!clientOpt.isPresent())
                throw new RuntimeException("Client reference not found");
            else {
                try {
                    this.clientReferenceRepo.deleteById(codeReference);
                } catch (Exception e) {
                    throw new RuntimeException("Data delete error");
                }
            }
        }
    }

}
