package com.matheus.email_sender_2.repository;

import com.matheus.email_sender_2.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
