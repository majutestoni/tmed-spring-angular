package estudo.spring.crud.controller;

import estudo.spring.crud.patient.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterPatient patient) {
        patientRepository.save(new Patient(patient));
    }

    @GetMapping
    public Page listPatients(@PageableDefault(size = 5) Pageable pageable) {
        return patientRepository.findAll(pageable).map(DataListPatient::new);
    }

    @PutMapping
    @Transactional
    public void updatePatient(@RequestBody @Valid DataUpdatePatient data) {
        var patient = patientRepository.getReferenceById(data.id());
        patient.updateDatas(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
