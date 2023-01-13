package estudo.spring.crud.patient;

import jakarta.validation.constraints.NotNull;

public record DataUpdatePatient(
        @NotNull
        Long id,
        String phone,
        String email
) {
}
