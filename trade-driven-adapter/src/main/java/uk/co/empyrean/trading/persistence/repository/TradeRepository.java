package uk.co.empyrean.trading.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.empyrean.trading.persistence.model.TradeJpaEntity;

import java.util.UUID;

@Repository
public interface TradeRepository extends JpaRepository<TradeJpaEntity, UUID> {
}
