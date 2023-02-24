package estudo.spring.crud.domain.appointment.validation;


import estudo.spring.crud.domain.appointment.DataRegisterAppointment;
import estudo.spring.crud.domain.appointment.validationAppointment;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidationTime {

    public void validation(DataRegisterAppointment appointment) {
        var dateAppointment = appointment.dateA();
        var timeAppointment = appointment.timeA();

        var sunday = dateAppointment.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeOpen = timeAppointment.getHour() < 7;
        var afterClose = timeAppointment.getHour() > 18;

        if (sunday || afterClose || afterClose) {
            throw new validationAppointment("time is wrong");
        }
    }


}
