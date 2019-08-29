package jsontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger.web.SecurityConfiguration;

@SpringBootApplication()
public class JsonRunner {
    public static void main(String[] args) {
        SpringApplication.run(JsonRunner.class,args);
    }
}
