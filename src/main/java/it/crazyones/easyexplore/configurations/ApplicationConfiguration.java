package it.crazyones.easyexplore.configurations;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.validation.constraints.Min;

/**
 * Created by bilal90 on 9/11/2017.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
//    @Getter
//    @NotBlank
//    @Value("${schedule.storage.path}")
//    private String storageSchedulePath;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
