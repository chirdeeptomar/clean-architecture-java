package uk.co.empyrean.trading.core.application.service;

import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.core.application.ports.external.GetStockPricePort;
import uk.co.empyrean.trading.core.application.ports.internal.GetStockPriceUseCase;

import java.util.Optional;

@Component
public class GetStockPriceService implements GetStockPriceUseCase {

    private final GetStockPricePort getStockPricePort;

    public GetStockPriceService(GetStockPricePort getStockPricePort) {
        this.getStockPricePort = getStockPricePort;
    }

    @Override
    public Optional<Float> getStockPrice(GetStockPriceCommand command) {
        return getStockPricePort.getStockPrice(command.getStock());
    }
}
