package org.Rohit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectFactory {
    public ObjectFactory() {
        System.out.println("Configuratuion does create an object..!! ");
    }
    @Bean
    @Primary
    public mailSender printName(){
        System.out.println("Testing Configuration class !!! ");
        return new mailSender("Hello Rohit sirr !!! ");
    }
    @Bean
    public mailSender chngeMessage(){
        System.out.println("Testing Configuration  Another class !!! ");
        return new mailSender("hii TanwarBoy");
    }

}
