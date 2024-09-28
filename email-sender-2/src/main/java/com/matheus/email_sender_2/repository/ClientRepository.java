package com.matheus.email_sender_2.repository;

import com.matheus.email_sender_2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {
}
