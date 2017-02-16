package settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainFrameConfig {
	@Bean
	public int mainWidth() {
		return 500;
	}

	@Bean
	public int mainHeight() {
		return 500;
	}

	@Bean
	public String mainTitle() {
		return "Main";
	}
}
