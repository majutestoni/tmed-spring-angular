package estudo.spring.crud.domain.appointment;

import estudo.spring.crud.domain.appointment.validation.ValidationTime;
import estudo.spring.crud.domain.doctor.Doctor;
import estudo.spring.crud.domain.doctor.DoctorRepository;
import estudo.spring.crud.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AppointmentRegister {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired

    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ValidationTime validationTime;

    public ResponseEntity agendar(DataRegisterAppointment data, UriComponentsBuilder builder) {
        if (!patientRepository.existsById(data.patientId())) {
            throw new validationAppointment("Patient id not exist");
        }
        if (data.doctorId() != null && !doctorRepository.existsById(data.doctorId())) {
            throw new validationAppointment("Doctor id not exist");
        }

        validationTime.validation(data);

        var patient = patientRepository.findById(data.patientId()).get();
        var doctor = choseDoctor(data);

        var appointment = new Appointment(null, doctor, patient, data.dateA(), data.timeA());
        appointmentRepository.save(appointment);

        var uri = builder.path("/appointment/{id}").buildAndExpand(appointment.getId()).toUri();

        return ResponseEntity.created(uri).body(data);
    }

    private Doctor choseDoctor(DataRegisterAppointment data) {

        if (data.doctorId() != null) {
            return doctorRepository.getReferenceById(data.doctorId());
        }

        if (data.specialty() == null) {
            throw new validationAppointment("specialty is required");
        }

        return doctorRepository.choseDoctor(data.specialty(), data.dateA());
    }

}
