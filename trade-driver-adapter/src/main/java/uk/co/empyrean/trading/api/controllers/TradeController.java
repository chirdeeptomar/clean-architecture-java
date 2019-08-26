package uk.co.empyrean.trading.api.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.empyrean.trading.application.ports.in.BuyStockUseCase;
import uk.co.empyrean.trading.application.ports.in.BuyStockUseCase.BuyStockCommand;
import uk.co.empyrean.trading.api.requests.BuyStockRequest;

import java.util.Currency;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api/trades", consumes = "application/json")
public class TradeController {

    private final BuyStockUseCase buyStockUseCase;

    @PostMapping
    public boolean buyStock(BuyStockRequest request) {
        BuyStockCommand command = new BuyStockCommand(
                request.getQuantity(),
                Currency.getInstance(request.getCurrencyCode()),
                request.getStock(),
                request.getBuyer(),
                request.getSeller(),
                request.getRate()
        );
        return buyStockUseCase.buyStock(command);
    }
}
