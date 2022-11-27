package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.client.model.ClientReference;

public interface ClientReferenceRepository extends JpaRepository<ClientReference, Integer> {
    List<ClientReference> findByKeyCode(Integer codeReference);
    List<ClientReference> findByKeyIdentificationtype(String identificationType);
    List<ClientReference> findByKeyIdentification(String identification);
}
