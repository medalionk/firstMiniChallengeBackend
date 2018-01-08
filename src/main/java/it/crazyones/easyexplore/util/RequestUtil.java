package it.crazyones.easyexplore.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by bilal90 on 9/27/2017.
 */
public final class RequestUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestUtil.class);
    public static ResponseEntity<String> makeRequest (RestTemplate restTemplate, String url, String body,
                                                String params, HttpMethod method, HttpHeaders headers)
    {
        try {
            HttpEntity<String> entity = new HttpEntity<>(body, headers);
            return restTemplate.exchange(url, method, entity, String.class, params);
        }catch (Exception e){
            LOGGER.error("Error making a {} request to {} with {} and {}",
                    method.toString(), url, body, params, e);
            return null;
        }
    }

    public static HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set( "Content-Type", "application/json;charset=UTF-8" );
        }};
    }

    public static URL getBaseUrl(HttpServletRequest request){
        try {
            return new URL(request.getScheme(), request.getServerName(), request.getServerPort(),
                    request.getContextPath().concat(request.getRequestURI()));
        } catch (MalformedURLException e) {
            LOGGER.error("Error constructing the base url '{}'", e.getMessage());
            return null;
        }
    }
}
