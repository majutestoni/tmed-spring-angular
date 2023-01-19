package estudo.spring.crud.domain.doctor;

public record DataCompleteDoctor(Long id, String name, String email, String crm, Specialty specialty, boolean active) {
    public DataCompleteDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty(), doctor.isActive());
    }
}
