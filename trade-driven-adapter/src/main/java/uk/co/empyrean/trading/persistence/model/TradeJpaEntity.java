package uk.co.empyrean.trading.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Data
@Entity
public class TradeJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime timestamp;
    private Integer quantity;
    private Currency currency;
    private String stock;
    private String buyer;
    private String seller;
    private float rate;
}
