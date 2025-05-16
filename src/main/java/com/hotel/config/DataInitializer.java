package com.hotel.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hotel.model.Staff;
import com.hotel.repository.StaffRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StaffRepository staffRepository;

    @Autowired
    public DataInitializer(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only add test data if staff table is empty
        if (staffRepository.count() == 0) {
            Staff staff1 = new Staff();
            staff1.setFirstName("John");
            staff1.setLastName("Smith");
            staff1.setEmail("john.smith@hotel.com");
            staff1.setPhoneNumber("1234567890");
            staff1.setDepartment("RECEPTION");
            staff1.setPosition("MANAGER");
            staff1.setHireDate(LocalDate.of(2023, 1, 15));
            staff1.setStatus("ACTIVE");
            staff1.setAddress("123 Hotel Street, City");
            staff1.setEmergencyContact("Jane Smith");
            staff1.setEmergencyPhone("0987654321");
            staff1.setNotes("Senior staff member with extensive experience");
            
            staffRepository.save(staff1);
            
            Staff staff2 = new Staff();
            staff2.setFirstName("Emily");
            staff2.setLastName("Johnson");
            staff2.setEmail("emily.johnson@hotel.com");
            staff2.setPhoneNumber("2345678901");
            staff2.setDepartment("HOUSEKEEPING");
            staff2.setPosition("SUPERVISOR");
            staff2.setHireDate(LocalDate.of(2023, 3, 20));
            staff2.setStatus("ACTIVE");
            staff2.setAddress("456 Hotel Avenue, City");
            staff2.setEmergencyContact("Michael Johnson");
            staff2.setEmergencyPhone("1098765432");
            staff2.setNotes("Excellent attention to detail");
            
            staffRepository.save(staff2);
            
            System.out.println("Sample staff data initialized");
        }
    }
} 