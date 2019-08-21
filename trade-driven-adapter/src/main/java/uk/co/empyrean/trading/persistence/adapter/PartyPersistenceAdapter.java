package uk.co.empyrean.trading.persistence.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.application.ports.out.LoadPartyDetailsPort;
import uk.co.empyrean.trading.domain.Trade;
import uk.co.empyrean.trading.persistence.model.PartyJpaEntity;
import uk.co.empyrean.trading.persistence.repository.PartyRepository;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PartyPersistenceAdapter implements LoadPartyDetailsPort {

    private final PartyRepository partyRepository;

    @Override
    public Optional<Trade.Party> getPartyById(UUID id) {
        Optional<PartyJpaEntity> party = partyRepository.findById(id);
        return party.map(p -> new Trade.Party(p.getId(), p.getName()));
    }
}
