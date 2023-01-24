package estudo.spring.crud.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataComeIn(
        @NotNull @NotBlank
        String username,
        @NotNull @NotBlank
        String password) {
}
