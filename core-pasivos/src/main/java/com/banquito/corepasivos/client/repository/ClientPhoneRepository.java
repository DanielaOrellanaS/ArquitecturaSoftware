package com.banquito.corepasivos.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.ClientPhone;
import com.banquito.corepasivos.client.model.ClientPhonePK;

@Repository
public interface ClientPhoneRepository extends JpaRepository<ClientPhone, ClientPhonePK> {
    List<ClientPhone> findByPkIdentificationAndPkIdentificationtype(String id, String identificationType);

    List<ClientPhone> deleteByPkIdentificationAndPkIdentificationtype(String id, String identificationType);
}
