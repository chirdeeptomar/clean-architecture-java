package uk.co.empyrean.trading.driver.api.requests;

import lombok.Data;

import java.util.UUID;

@Data
public class BuyStockRequest {
    private Integer quantity;
    private String currencyCode;
    private String stock;
    private UUID buyer;
    private UUID seller;
    private double rate;
}