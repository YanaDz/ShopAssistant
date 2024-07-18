package pl.dziadkouskaya.graphql.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class EnvConfig {

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        Dotenv dotenv = Dotenv.configure().load();
        Map<String, Object> envMap = new HashMap<>();
        dotenv.entries().forEach(entry -> envMap.put(entry.getKey(), entry.getValue()));

        for (Map.Entry<String, Object> entry : envMap.entrySet()) {
            System.setProperty(entry.getKey(), entry.getValue().toString());
        }
    }
}
