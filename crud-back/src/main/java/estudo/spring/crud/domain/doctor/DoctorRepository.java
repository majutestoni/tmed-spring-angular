package estudo.spring.crud.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue(Pageable pageable);

    @Query(value = "select d from doctors d where d.active = 1 and d.specialty = :specialty and d.id not in(select a.doctor from appointments a where a.dateA = :dateA) order by rand() limit 1", nativeQuery = true)
    Doctor choseDoctor(Specialty specialty, LocalDate dateA);
}
