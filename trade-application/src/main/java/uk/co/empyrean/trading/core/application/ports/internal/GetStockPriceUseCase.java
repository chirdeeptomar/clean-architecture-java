package uk.co.empyrean.trading.core.application.ports.internal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uk.co.empyrean.hexagon.SelfValidating;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface GetStockPriceUseCase {

    Optional<Float> getStockPrice(GetStockPriceCommand stock);

    @Getter
    @RequiredArgsConstructor
    class GetStockPriceCommand extends SelfValidating<GetStockPriceCommand> {

        @NotNull
        private final String stock;

        @Override
        public void validate() {
            this.validateSelf(this);
        }
    }
}
