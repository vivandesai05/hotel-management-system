package com.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotel.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    
    @Query("SELECT s FROM Staff s WHERE s.department = :department")
    List<Staff> findByDepartment(@Param("department") String department);
    
    @Query("SELECT s FROM Staff s WHERE s.position = :position")
    List<Staff> findByPosition(@Param("position") String position);
    
    @Query("SELECT s FROM Staff s WHERE s.status = :status")
    List<Staff> findByStatus(@Param("status") String status);
    
    @Query("SELECT s FROM Staff s WHERE s.email = :email")
    Staff findByEmail(@Param("email") String email);
} 