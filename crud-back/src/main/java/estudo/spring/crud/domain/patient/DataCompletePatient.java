package estudo.spring.crud.domain.patient;

import estudo.spring.crud.domain.address.Address;

public record DataCompletePatient(Long id, String name, String email, String phone, Address address) {
    public DataCompletePatient(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getAddress());
    }

}
