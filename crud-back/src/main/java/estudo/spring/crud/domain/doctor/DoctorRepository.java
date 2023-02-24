package estudo.spring.crud.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable pageable);

    @Query("select d from Doctor d where m.active = 1 and m.specialty = :specialty " +
            "and m.id not in(select a.doctor from Appointment a where a.date = :dateA) order by rand() limit 1")
    Doctor choseDoctor(Specialty specialty, LocalDate dateA);
}
