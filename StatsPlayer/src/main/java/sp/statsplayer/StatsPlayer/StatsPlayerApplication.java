package sp.statsplayer.StatsPlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import sp.statsplayer.StatsPlayer.security.SecurityConfig;
//app
@SpringBootApplication
@Import(SecurityConfig.class)
public class StatsPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatsPlayerApplication.class, args);
    }

}
