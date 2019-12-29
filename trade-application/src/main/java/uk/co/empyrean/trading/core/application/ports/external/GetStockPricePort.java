package uk.co.empyrean.trading.core.application.ports.external;

import java.util.Optional;

public interface GetStockPricePort {
    Optional<Float> getStockPrice(String stock);
}
