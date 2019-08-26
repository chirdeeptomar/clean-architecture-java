package uk.co.empyrean.trading.api.requests;

import lombok.Value;

import java.util.UUID;

@Value
public class BuyStockRequest {
    private Integer quantity;
    private String currencyCode;
    private String stock;
    private UUID buyer;
    private UUID seller;
    private float rate;
}
