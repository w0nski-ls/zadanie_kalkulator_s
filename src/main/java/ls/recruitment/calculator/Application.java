package ls.recruitment.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "ls.recruitment.calculator" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
