package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.client.model.ClientReference;

public interface ClientReferenceRepository extends JpaRepository<ClientReference, Integer> {
    List<ClientReference> findByPkCode(Integer codeReference);
    List<ClientReference> findByPkIdentificationtype(String identificationType);
    List<ClientReference> findByPkIdentification(String identification);
}
