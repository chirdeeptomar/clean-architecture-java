package uk.co.empyrean.trading.driver.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.empyrean.trading.core.application.ports.internal.BuyStockUseCase;
import uk.co.empyrean.trading.driver.api.requests.BuyStockRequest;

import javax.validation.ConstraintViolationException;
import java.util.Currency;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api/trades", consumes = "application/json")
public class TradeController {

    private final BuyStockUseCase buyStockUseCase;

    @PostMapping
    public ResponseEntity<Boolean> buyStock(@RequestBody BuyStockRequest request) {
        BuyStockUseCase.BuyStockCommand command = new BuyStockUseCase.BuyStockCommand(
                request.getQuantity(),
                Currency.getInstance(request.getCurrencyCode()),
                request.getStock(),
                request.getBuyer(),
                request.getSeller(),
                request.getRate()
        );

        try {
            command.validate();
        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(buyStockUseCase.buyStock(command));
    }
}
