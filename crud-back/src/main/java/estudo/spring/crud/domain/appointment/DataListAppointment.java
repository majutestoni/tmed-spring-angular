package estudo.spring.crud.domain.appointment;

import estudo.spring.crud.domain.doctor.Doctor;
import estudo.spring.crud.domain.patient.Patient;

import java.time.LocalDate;
import java.time.LocalTime;

public record DataListAppointment(Long id, Doctor doctor, Patient patient, LocalDate dateA, LocalTime timeA) {
    public DataListAppointment(Appointment appointment){
        this(appointment.getId(), appointment.getDoctor(), appointment.getPatient(), appointment.getDateA(), appointment.getTimeA());
    }

}
