package murraco.repository;

import murraco.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    Optional<Insurance> findInsuranceById(Long id);

    @Transactional
    void deleteInsuranceById(Long id);
}
