package estudo.spring.crud.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
