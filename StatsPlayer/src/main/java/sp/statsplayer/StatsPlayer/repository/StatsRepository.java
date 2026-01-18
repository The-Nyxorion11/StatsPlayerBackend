package sp.statsplayer.StatsPlayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.statsplayer.StatsPlayer.model.Stats;

public interface StatsRepository extends JpaRepository<Stats, String> {
}
