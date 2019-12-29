package uk.co.empyrean.trading.core.application.ports.internal;

import uk.co.empyrean.hexagon.SelfValidating;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface GetStockPriceUseCase {

    Optional<Float> getStockPrice(GetStockPriceCommand stock);

    class GetStockPriceCommand extends SelfValidating<GetStockPriceCommand> {

        @NotNull
        private String stock;

        public GetStockPriceCommand(String stock) {
            this.stock = stock;
            this.validateSelf(this);
        }

        public String getStock() {
            return stock;
        }
    }
}
