package estudo.spring.crud.domain.patient;

import jakarta.validation.constraints.NotNull;

public record DataUpdatePatient(
        @NotNull
        Long id,
        String phone,
        String email
) {
}
