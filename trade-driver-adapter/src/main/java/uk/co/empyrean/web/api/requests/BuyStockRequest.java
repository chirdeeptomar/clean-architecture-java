package uk.co.empyrean.web.api.requests;

import lombok.Value;

import java.util.Currency;
import java.util.UUID;

@Value
public class BuyStockRequest {
    private Integer quantity;
    private Currency currency;
    private String stock;
    private UUID buyer;
    private UUID seller;
    private float rate;
}
