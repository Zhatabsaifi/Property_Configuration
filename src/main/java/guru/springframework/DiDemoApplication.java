package guru.springframework;

import guru.springframework.controllers.MyController;
import guru.springframework.examplebeans.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);


		System.out.println("hello world");
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getDburl());

		System.out.println("hello world");
		// ---------multiple file--------
		FakeJmsConfig fakeJmsConfig = (FakeJmsConfig) ctx.getBean(FakeJmsConfig.class);
		System.out.println(fakeJmsConfig.getUsername());
		System.out.println(fakeJmsConfig.getUrl());
	}
}
