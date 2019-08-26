package uk.co.empyrean.trading.persistence.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.application.ports.out.CommitTradePort;
import uk.co.empyrean.trading.domain.Trade;
import uk.co.empyrean.trading.persistence.model.TradeJpaEntity;
import uk.co.empyrean.trading.persistence.repository.TradeRepository;

@Component
@AllArgsConstructor
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
