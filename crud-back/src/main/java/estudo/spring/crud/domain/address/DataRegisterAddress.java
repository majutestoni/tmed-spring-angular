package estudo.spring.crud.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataRegisterAddress(
        @NotBlank
        String city,
        @NotBlank
        String uf) {
}
