package fr.schmidt.insuranceapi.repository;

import fr.schmidt.insuranceapi.entity.Assure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssureRepository extends JpaRepository<Assure, Long> {
    Optional<Assure> findByEmail(String email);
}
