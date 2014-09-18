package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.ChainAction;
import ratpack.handling.Context;
import ratpack.handling.Handler;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {	
	@Bean
    public Action<Chain> createChain() {
		return new Routes();
	}
	
	@Bean
	public Action<Chain> createBasicChain() {
		return new ChainAction() {
			@Override
			protected void execute() throws Exception {
				get("simple", new Handler() {					
					@Override
					public void handle(Context context) throws Exception {
						context.getResponse().send("I am a simple page.");
					}
				});
			}
		};
	}

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
