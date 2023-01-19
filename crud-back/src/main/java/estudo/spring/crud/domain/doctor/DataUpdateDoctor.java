package estudo.spring.crud.domain.doctor;

import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctor(
        @NotNull
        Long id,
        String name,
        String email) {
}
