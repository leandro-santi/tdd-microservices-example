package com.example.tdd.repository;

import com.example.tdd.models.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingModel, String> {

    Optional<BookingModel> findBookingModelByReserveName(String name);

}