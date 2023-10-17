package myspring.di.strategy.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "myspring.di.strategy2.dao", "myspring.di.strategy2.service" })
public class AnnotatedUserConfig {

}
