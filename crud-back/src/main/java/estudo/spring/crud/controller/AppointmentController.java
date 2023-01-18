package estudo.spring.crud.controller;

import estudo.spring.crud.appointment.Appointment;
import estudo.spring.crud.appointment.AppointmentRepository;
import estudo.spring.crud.appointment.DataRegisterAppointment;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping
    @Transactional
    void postAppointment(@RequestBody @Valid DataRegisterAppointment appointment) {
        appointmentRepository.save(new Appointment(appointment));
    }

}
