package uk.co.empyrean.trading.core.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.core.application.ports.external.GetStockPricePort;
import uk.co.empyrean.trading.core.application.ports.internal.GetStockPriceUseCase;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class GetStockPriceService implements GetStockPriceUseCase {

    private final GetStockPricePort getStockPricePort;

    @Override
    public Optional<Float> getStockPrice(GetStockPriceCommand command) {
        return getStockPricePort.getStockPrice(command.getStock());
    }
}
