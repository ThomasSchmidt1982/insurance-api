package fr.schmidt.insuranceapi.repository;

import fr.schmidt.insuranceapi.entity.Formule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormuleRepository extends JpaRepository <Formule, Long> {
}
