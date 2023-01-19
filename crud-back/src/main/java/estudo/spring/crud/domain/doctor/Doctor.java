package estudo.spring.crud.domain.doctor;

import estudo.spring.crud.domain.appointment.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    private String crm;
    private boolean active;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Doctor(DataRegisterDoctor doctor) {
        this.name = doctor.name();
        this.email = doctor.email();
        this.specialty = doctor.specialty();
        this.crm = doctor.crm();
        this.active = true;
    }

    public Doctor(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.email = doctor.getEmail();
        this.specialty = doctor.getSpecialty();
        this.crm = doctor.getCrm();
    }

    public void desactive() {
        this.active = false;
    }

    public void updateData(DataUpdateDoctor doctor) {
        if (doctor.name() != null && !doctor.name().isBlank()) {
            this.name = doctor.name();
        }
        if (doctor.email() != null && !doctor.email().isBlank()) {
            this.email = doctor.email();
        }
    }
}
