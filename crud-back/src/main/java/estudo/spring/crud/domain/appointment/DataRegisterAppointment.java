package estudo.spring.crud.domain.appointment;

import estudo.spring.crud.domain.doctor.Specialty;
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
        LocalTime timeA,
        Specialty specialty
) {
}
