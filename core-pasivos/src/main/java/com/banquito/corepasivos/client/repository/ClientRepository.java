package com.banquito.corepasivos.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.client.model.Client;
import com.banquito.corepasivos.client.model.ClientPK;

@Repository
public interface ClientRepository extends JpaRepository<Client, ClientPK> {

}
