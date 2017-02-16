package settings;

import components.views.MainFrame;
import components.views.Showable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("components")
@Configuration
public class AppConfig {

	@Bean
	public Showable mainFrame() {
		return new MainFrame();
	}

	@Bean
	public String logFileName() {
		return "log.txt";
	}
}
