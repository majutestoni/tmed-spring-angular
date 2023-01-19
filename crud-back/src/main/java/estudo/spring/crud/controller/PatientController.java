package estudo.spring.crud.controller;

import estudo.spring.crud.domain.patient.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataRegisterPatient patient, UriComponentsBuilder builder) {
        var data = new Patient(patient);
        patientRepository.save(data);
        var uri = builder.path("/patient/{id}").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataCompletePatient(data));
    }

    @GetMapping
    public ResponseEntity<Page> listPatients(@PageableDefault(size = 5) Pageable pageable) {
        var page = patientRepository.findAll(pageable).map(DataListPatient::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid DataUpdatePatient data) {
        var patient = patientRepository.getReferenceById(data.id());
        patient.updateDatas(data);
        return ResponseEntity.ok(new DataCompletePatient(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        // não é uma boa pratica em razão de usarmos chave estrangeira
        patientRepository.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatientInfos(@PathVariable Long id){
        var patient = patientRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataCompletePatient(patient));
    }
}
