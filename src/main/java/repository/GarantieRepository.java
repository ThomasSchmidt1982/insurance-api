package fr.schmidt.insuranceapi.repository;

import fr.schmidt.insuranceapi.entity.Garantie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GarantieRepository extends JpaRepository<Garantie, Long> {
    List<Garantie> findByFormuleId(Long formuleId);
}
