package estudo.spring.crud.domain.appointment;

public class validationAppointment extends RuntimeException {
    public validationAppointment(String mes) {
        super(mes);
    }
}
