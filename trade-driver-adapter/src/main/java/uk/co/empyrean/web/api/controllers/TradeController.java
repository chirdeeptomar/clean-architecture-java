package uk.co.empyrean.web.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.empyrean.trading.application.ports.in.BuyStockUseCase;
import uk.co.empyrean.trading.application.ports.in.BuyStockUseCase.BuyStockCommand;
import uk.co.empyrean.web.api.requests.BuyStockRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/trades")
public class TradeController {

    private final BuyStockUseCase buyStockUseCase;

    @PostMapping
    public boolean buyStock(BuyStockRequest request) {
        BuyStockCommand command = new BuyStockCommand(
                request.getQuantity(),
                request.getCurrency(),
                request.getStock(),
                request.getBuyer(),
                request.getSeller(),
                request.getRate()
        );
        return buyStockUseCase.buyStock(command);
    }
}
