package estudo.spring.crud.domain.appointment;

import estudo.spring.crud.domain.doctor.Doctor;
import estudo.spring.crud.domain.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor = new Doctor();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient = new Patient();

    private LocalDate dateA;
    private LocalTime timeA;

    public Appointment(DataRegisterAppointment appointment) {
        this.doctor.setId(appointment.doctorId());
        this.patient.setId(appointment.doctorId());
        this.patient.setId(appointment.doctorId());
        this.dateA = appointment.dateA();
        this.timeA = appointment.timeA();
    }
}
