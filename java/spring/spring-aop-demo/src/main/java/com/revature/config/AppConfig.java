package com.revature.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.*;

// This class is used for programmatic bean registration with the container (aka: ApplicationContext)
@Configuration
@ComponentScan("com.revature") // if no package string is provided, then Spring will scan the package that this class is in for components
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true) // the arguments let's Spring know that we intend to use CGLib (class-based) proxies, instead of JDK (interface-based proxies)
public class AppConfig {

    // Other bean definitions would still go here for any other components that we wanted to declare for Spring

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
