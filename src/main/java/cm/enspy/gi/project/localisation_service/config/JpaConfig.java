package cm.enspy.gi.project.localisation_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bedatadriven.jackson.datatype.jts.JtsModule;



@Configuration 
public class JpaConfig {


    @Bean
    JtsModule jtsModule(){

        return new JtsModule();
    }
    
}
