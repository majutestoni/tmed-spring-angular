package estudo.spring.crud.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DataRegisterAppointment(
        @NotNull
        Long doctorId,
        @NotNull
        Long patientId,
        @NotNull
        LocalDate dateA,
        @NotNull
        LocalTime timeA
) {
}
