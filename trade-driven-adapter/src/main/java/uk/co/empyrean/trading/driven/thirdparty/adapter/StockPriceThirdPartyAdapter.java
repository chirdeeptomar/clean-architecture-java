package uk.co.empyrean.trading.driven.thirdparty.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.core.application.ports.external.GetStockPricePort;
import uk.co.empyrean.trading.driven.thirdparty.client.StockPriceFetcher;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class StockPriceThirdPartyAdapter implements GetStockPricePort {
    private final StockPriceFetcher stockPriceFetcher;

    @Override
    public Optional<Float> getStockPrice(String stock) {
        return Optional.of(stockPriceFetcher.getStockPrice(stock));
    }
}
