package com.hotel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.model.Booking;
import com.hotel.model.Guest;
import com.hotel.model.Room;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.GuestRepository;
import com.hotel.repository.RoomRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        // Check if room is available
        Room room = roomRepository.findById(booking.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));
        
        if (!room.getIsAvailable()) {
            throw new RuntimeException("Room is not available");
        }

        // Check if guest exists
        Guest guest = guestRepository.findById(booking.getGuest().getId())
                .orElseThrow(() -> new RuntimeException("Guest not found"));

        // Set the room and guest
        booking.setRoom(room);
        booking.setGuest(guest);
        booking.setBookingStatus("PENDING");

        // Mark room as unavailable
        room.setIsAvailable(false);
        roomRepository.save(room);

        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setCheckInDate(bookingDetails.getCheckInDate());
        booking.setCheckOutDate(bookingDetails.getCheckOutDate());
        booking.setTotalPrice(bookingDetails.getTotalPrice());
        booking.setBookingStatus(bookingDetails.getBookingStatus());
        booking.setSpecialRequests(bookingDetails.getSpecialRequests());

        return bookingRepository.save(booking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Mark room as available again
        Room room = booking.getRoom();
        room.setIsAvailable(true);
        roomRepository.save(room);

        bookingRepository.delete(booking);
    }

    public List<Booking> findByGuestId(Long guestId) {
        return bookingRepository.findByGuestId(guestId);
    }

    public List<Booking> findByRoomId(Long roomId) {
        return bookingRepository.findByRoomId(roomId);
    }

    public List<Booking> findByCheckInDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return bookingRepository.findByCheckInDateBetween(startDate, endDate);
    }
} 