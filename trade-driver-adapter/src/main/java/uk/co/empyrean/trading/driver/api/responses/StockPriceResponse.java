package uk.co.empyrean.trading.driver.api.responses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StockPriceResponse {
    private final String stock;
    private final float price;
}
