package it.crazyones.easyexplore.configurations;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bilal90 on 9/14/2017.
 */
@Configuration
public class ObjectMapperConfiguration {
    private ObjectMapper springHateoasObjectMapper;

    @Bean(name = "_halObjectMapper")
    ObjectMapper objectMapper() {
        return springHateoasObjectMapper
                .configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .registerModules(new JavaTimeModule());
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate _restTemplate = new RestTemplate();
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        messageConverters.add(new MappingJackson2HttpMessageConverter(springHateoasObjectMapper));
//        _restTemplate.setMessageConverters(messageConverters);
        return _restTemplate;
    }
}
