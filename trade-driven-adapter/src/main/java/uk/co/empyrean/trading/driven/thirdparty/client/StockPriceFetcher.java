package uk.co.empyrean.trading.driven.thirdparty.client;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class StockPriceFetcher {
    public Float getStockPrice(String stock) {
        return ThreadLocalRandom.current().nextFloat();
    }
}
