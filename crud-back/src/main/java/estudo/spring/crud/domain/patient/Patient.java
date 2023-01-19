package estudo.spring.crud.domain.patient;

import estudo.spring.crud.domain.address.Address;
import estudo.spring.crud.domain.appointment.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "patient")
    List<Appointment> appointments;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Patient(DataRegisterPatient patient) {
        this.name = patient.name();
        this.email = patient.email();
        this.phone = patient.phone();
        this.address = new Address(patient.address());
    }

    public void updateDatas(DataUpdatePatient data) {
        if (data.email() != null && !data.email().isBlank()) {
            this.email = data.email();
        }
        if (data.phone() != null && !data.phone().isBlank()) {
            this.phone = data.phone();
        }
    }
}
