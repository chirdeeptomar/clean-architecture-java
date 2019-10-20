package uk.co.empyrean.trading.core.application.ports.internal;

import uk.co.empyrean.hexagon.SelfValidating;

import javax.validation.constraints.NotNull;

public interface GetStockPriceUseCase {
    Long getStockPrice(String tick);

    class GetStockPriceCommand extends SelfValidating<GetStockPriceCommand> {

        @NotNull
        private String tick;

        public GetStockPriceCommand(String tick) {
            this.tick = tick;
            this.validateSelf();
        }
    }
}
