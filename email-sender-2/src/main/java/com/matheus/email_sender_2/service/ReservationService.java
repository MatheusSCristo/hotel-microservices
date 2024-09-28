package com.matheus.email_sender_2.service;

import com.matheus.email_sender_2.model.Reservation;
import com.matheus.email_sender_2.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findReservationById(String reservationId){
        return reservationRepository.findById(reservationId).orElse(null);
    }

}
