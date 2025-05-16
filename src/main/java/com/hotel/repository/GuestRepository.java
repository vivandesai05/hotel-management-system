package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByEmail(String email);
} 