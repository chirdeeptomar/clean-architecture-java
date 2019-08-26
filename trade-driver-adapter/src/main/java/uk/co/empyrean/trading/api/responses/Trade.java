package uk.co.empyrean.trading.api.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Data
@Builder
public class Trade {
    private UUID id;
    private LocalDateTime timestamp;
    private Integer quantity;
    private Currency currency;
    private String stock;
    private String buyer;
    private String seller;
    private float rate;
}
