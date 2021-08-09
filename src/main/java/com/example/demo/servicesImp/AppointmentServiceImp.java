package com.example.demo.servicesImp;

import com.example.demo.dto.AppointmentFormDto;
import com.example.demo.models.Appointment;
import com.example.demo.models.Patient;
import com.example.demo.repositories.AppointmentRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AppointmentServiceImp implements AppointmentService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;
//
//    public String bookAppointment(AppointmentFormDto appointmentFormDto) {
//        Patient patient = new ObjectMapper().convertValue(appointmentFormDto, Patient.class);
//        int patientId = patientRepo.save(patient).getId();
//        System.out.println(">>>>>>>>>patient saved successfully!!!<<<<<<<<<");
//
//
//        System.out.println(10 / 0);
//        Appointment appointment = Appointment.builder()
//                .date(new Date(System.currentTimeMillis()))
//                .doctorId(4)
//                .patientId(patientId)
//                .build();
//        int appointmentId = appointmentRepo.save(appointment).getId();
//
//        return "Appointment booked successfully!! with : " + appointmentId;
//    }
}
