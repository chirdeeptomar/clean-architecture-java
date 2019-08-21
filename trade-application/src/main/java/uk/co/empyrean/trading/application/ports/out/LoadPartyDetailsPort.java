package uk.co.empyrean.trading.application.ports.out;

import uk.co.empyrean.trading.domain.Trade;

import java.util.Optional;
import java.util.UUID;

public interface LoadPartyDetailsPort {
    Optional<Trade.Party> getPartyById(UUID id);
}
