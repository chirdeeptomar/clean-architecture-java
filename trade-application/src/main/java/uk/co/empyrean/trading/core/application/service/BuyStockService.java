package uk.co.empyrean.trading.core.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.core.application.ports.external.CommitTradePort;
import uk.co.empyrean.trading.core.application.ports.external.LoadPartyDetailsPort;
import uk.co.empyrean.trading.core.application.ports.internal.BuyStockUseCase;
import uk.co.empyrean.trading.core.domain.Trade;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class BuyStockService implements BuyStockUseCase {

    private final CommitTradePort commitTradePort;
    private final LoadPartyDetailsPort loadPartyDetailsPort;

    @Override
    public boolean buyStock(BuyStockCommand command) {
        Optional<Trade.Party> buyer = loadPartyDetailsPort.getPartyById(command.getBuyer());
        Optional<Trade.Party> seller = loadPartyDetailsPort.getPartyById(command.getSeller());

        if (buyer.isPresent() && seller.isPresent()) {
            Trade trade = getTradeEntity(command, buyer.get(), seller.get());
            commitTradePort.commitTrade(trade);
            return true;
        }
        return false;
    }

    private Trade getTradeEntity(BuyStockCommand command, Trade.Party buyer, Trade.Party seller) {
        return new Trade(LocalDateTime.now(),
                new Trade.Quantity(command.getQuantity()),
                command.getCurrency(),
                new Trade.Stock(command.getStock()),
                new Trade.Buyer(buyer.getId(), buyer.getName()),
                new Trade.Seller(seller.getId(), seller.getName()),
                new Trade.Rate(command.getRate())
        );
    }
}
