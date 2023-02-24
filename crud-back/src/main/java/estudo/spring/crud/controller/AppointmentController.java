package estudo.spring.crud.controller;

import estudo.spring.crud.domain.appointment.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentRegister appointmentRegister;

    @PostMapping
    @Transactional
    ResponseEntity postAppointment(@RequestBody @Valid DataRegisterAppointment appointment, UriComponentsBuilder builder) {
        var data = new Appointment(appointment);
        appointmentRepository.save(data);
        var uri = builder.path("/appointment/{id}").buildAndExpand(data.getId()).toUri();
        appointmentRegister.agendar(appointment);
        return ResponseEntity.created(uri).body(data);
    }

    @GetMapping
    ResponseEntity<Page> getAppointments(Pageable pageable){
        var page = appointmentRepository.findAll(pageable).map(DataListAppointment::new);
        return  ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    ResponseEntity getAppointment(@PathVariable Long id){
        var appointment = appointmentRepository.getReferenceById(id);
        return  ResponseEntity.ok(new DataListAppointment(appointment));
    }


}
