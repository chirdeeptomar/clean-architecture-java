package uk.co.empyrean.trading.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.application.ports.in.BuyStockUseCase;
import uk.co.empyrean.trading.application.ports.out.CommitTradePort;
import uk.co.empyrean.trading.application.ports.out.LoadPartyDetailsPort;
import uk.co.empyrean.trading.domain.Trade;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Transactional
@RequiredArgsConstructor
public class BuyStockService implements BuyStockUseCase {

    private final CommitTradePort commitTradePort;
    private final LoadPartyDetailsPort loadPartyDetailsPort;

    @Override
    public boolean buyStock(BuyStockCommand command) {
        Optional<Trade.Party> buyer = loadPartyDetailsPort.getPartyById(command.getBuyer());
        Optional<Trade.Party> seller = loadPartyDetailsPort.getPartyById(command.getSeller());

        if (buyer.isPresent() && seller.isPresent()) {
            Trade trade = Trade.builder()
                    .timestamp(LocalDateTime.now())
                    .currency(command.getCurrency())
                    .quantity(new Trade.Quantity(command.getQuantity()))
                    .stock(new Trade.Stock(command.getStock()))
                    .buyer(new Trade.Buyer(buyer.get().getId(), buyer.get().getName()))
                    .seller(new Trade.Seller(seller.get().getId(), seller.get().getName()))
                    .rate(new Trade.Rate(command.getRate()))
                    .build();

            commitTradePort.commitTrade(trade);
            return true;
        }
        return false;
    }
}
