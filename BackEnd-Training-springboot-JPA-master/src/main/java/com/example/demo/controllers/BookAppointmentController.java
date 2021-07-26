package com.example.demo.controllers;

import com.example.demo.dto.AppointmentFormDto;
import com.example.demo.servicesImp.AppointmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BookAppointmentController {


    @Autowired
    AppointmentServiceImp bookAppointmentService;

    @PostMapping("/book")
    public String bookAppointment(@RequestBody AppointmentFormDto appointmentFormDto) {
        return bookAppointmentService.bookAppointment(appointmentFormDto);
    }
}