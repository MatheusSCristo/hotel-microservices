package com.matheus.email_sender_2.service;

import com.matheus.email_sender_2.model.Hotel;
import com.matheus.email_sender_2.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private ReservationService reservationService;


    @KafkaListener(topics = "teste", groupId = "group_id")
    public void consumer(String id){
        Reservation reservation=reservationService.findReservationById(id);
        System.out.println("=== Detalhes da Reserva ===");
        System.out.println("ID da Reserva  : " + reservation.getId());
        System.out.println("Hotel          : " + reservation.getHotel().getName());
        System.out.println("Cidade         : " + reservation.getHotel().getCity());
        System.out.println("Cliente        : " + reservation.getClient().getName());
        System.out.println("Data da Reserva: " + reservation.getDate());
        System.out.println("===========================");
    }

}
