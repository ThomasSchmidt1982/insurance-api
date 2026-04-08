package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Remboursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateSoin;

    @Column(nullable = false)
    private String typeSoin;

    @Column(nullable = false)
    private BigDecimal montantFacture;

    private BigDecimal partMutuelle;

    // relation vers assure
    @ManyToOne
    @JoinColumn(name = "assure_id")
    private Assure assure;
}
