package estudo.spring.crud.controller;

import estudo.spring.crud.domain.doctor.*;
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
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    ResponseEntity createDoctor(@PageableDefault(size = 5) @RequestBody @Valid DataRegisterDoctor doctor, UriComponentsBuilder builder) {
        var data = new Doctor(doctor);
        doctorRepository.save(data);
        var uri = builder.path("/doctor/{id}").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataCompleteDoctor(data));
    }

    @GetMapping
    ResponseEntity<Page> listDoctor(Pageable pageable) {
        var page = this.doctorRepository.findAllByActiveTrue(pageable).map(DataListDoctor::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity desactiveDoctor(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.desactive();
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    ResponseEntity updateDoctor(@RequestBody @Valid DataUpdateDoctor json) {
        var doctor = doctorRepository.getReferenceById(json.id());
        doctor.updateData(json);

        return ResponseEntity.ok(new DataCompleteDoctor(doctor));
    }

    @GetMapping("/{id}")
    ResponseEntity getDoctorInfos(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataCompleteDoctor(doctor));
    }


}
