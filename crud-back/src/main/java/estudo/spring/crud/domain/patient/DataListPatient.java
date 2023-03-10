package estudo.spring.crud.domain.patient;

public record DataListPatient(Long id, String name, String email, String phone) {

    public DataListPatient(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone());
    }

}
