package estudo.spring.crud.patient;

import estudo.spring.crud.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
