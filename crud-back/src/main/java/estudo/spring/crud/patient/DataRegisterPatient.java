package estudo.spring.crud.patient;

import estudo.spring.crud.address.DataRegisterAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataRegisterPatient(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{9,14}")
        String phone,
        @NotNull @Valid DataRegisterAddress address
        ) {
}
