package com.example.demo.repositories;

import com.example.demo.models.Doctor;
import com.example.demo.models.DoctorPKId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, DoctorPKId> {
}
