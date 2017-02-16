import components.views.Showable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import settings.AppConfig;
import settings.MainFrameConfig;

public class EntryPoint {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class, MainFrameConfig.class);
		Showable mainFrame = (Showable) ctx.getBean("mainFrame");
		mainFrame.showFrame();
		ctx.close();
	}
}
