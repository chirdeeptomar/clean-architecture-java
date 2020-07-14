package uk.co.empyrean.trading.driven.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.core.application.ports.external.CommitTradePort;
import uk.co.empyrean.trading.core.domain.Trade;
import uk.co.empyrean.trading.driven.persistence.model.TradeJpaEntity;
import uk.co.empyrean.trading.driven.persistence.repository.TradeRepository;

@Component
@RequiredArgsConstructor
class TradePersistenceAdapter implements CommitTradePort {

    private final TradeRepository tradeRepository;

    @Override
    public void commitTrade(Trade trade) {
        TradeJpaEntity t = new TradeJpaEntity();
        t.setId(trade.getId());
        t.setTimestamp(trade.getTimestamp());
        t.setCurrency(trade.getCurrency());
        t.setBuyer(trade.getBuyer().getName());
        t.setSeller(trade.getSeller().getName());
        t.setQuantity(trade.getQuantity().getAmount());
        t.setRate(trade.getRate().getRate());
        t.setStock(trade.getStock().getName());
        this.tradeRepository.save(t);
    }
}
