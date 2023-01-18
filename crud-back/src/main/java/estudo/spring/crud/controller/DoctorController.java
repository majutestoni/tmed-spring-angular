package estudo.spring.crud.controller;

import estudo.spring.crud.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    void createDoctor(@PageableDefault(size = 5) @RequestBody @Valid DataRegisterDoctor doctor) {
        doctorRepository.save(new Doctor(doctor));
    }

    @GetMapping
    Page listDoctor(Pageable pageable) {
        return this.doctorRepository.findAllByActiveTrue(pageable).map(DataListDoctor::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    void desactiveDoctor(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.desactive();
    }

    @PutMapping
    @Transactional
    void updateDoctor(@RequestBody @Valid DataUpdateDoctor json) {
        var doctor = doctorRepository.getReferenceById(json.id());
        doctor.updateData(json);
    }


}
