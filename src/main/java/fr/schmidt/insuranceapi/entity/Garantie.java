package fr.schmidt.insuranceapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Garantie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String typeSoin;

    @Column(nullable = false)
    private BigDecimal tauxRemboursement;

    // relation vers formule
    @ManyToOne
    @JoinColumn(name = "formule_id")
    private Formule formule;

}
