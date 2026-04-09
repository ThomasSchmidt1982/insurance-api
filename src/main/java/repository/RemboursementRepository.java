package fr.schmidt.insuranceapi.repository;

import fr.schmidt.insuranceapi.entity.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    List<Remboursement> findByAssureId(Long assureId);
}
