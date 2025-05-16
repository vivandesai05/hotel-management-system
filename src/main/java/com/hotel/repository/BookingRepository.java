package com.hotel.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByGuestId(Long guestId);
    List<Booking> findByRoomId(Long roomId);
    List<Booking> findByCheckInDateBetween(LocalDateTime startDate, LocalDateTime endDate);
} 