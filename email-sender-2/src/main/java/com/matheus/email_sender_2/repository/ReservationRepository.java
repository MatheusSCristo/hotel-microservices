package com.matheus.email_sender_2.repository;

import com.matheus.email_sender_2.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
}
