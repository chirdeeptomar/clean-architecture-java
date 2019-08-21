package uk.co.empyrean.trading.application.ports.in;

import lombok.EqualsAndHashCode;
import lombok.Value;
import uk.co.empyrean.hexagon.SelfValidating;

import javax.validation.constraints.NotNull;

public interface GetStockPriceUseCase {
    Long getStockPrice(String tick);

    @Value
    @EqualsAndHashCode(callSuper = true)
    class GetStockPriceCommand extends SelfValidating<GetStockPriceCommand> {

        @NotNull
        private String tick;

        public GetStockPriceCommand(String tick) {
            this.tick = tick;
            this.validateSelf();
        }
    }
}
