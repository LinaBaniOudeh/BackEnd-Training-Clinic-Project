package com.example.demo.repositories;

import com.example.demo.models.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Integer> {
}
