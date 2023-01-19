package estudo.spring.crud.domain.doctor;

public record DataListDoctor(Long id, String name, String email, Specialty specialty, String crm) {

    public DataListDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getSpecialty(), doctor.getCrm());
    }
}
