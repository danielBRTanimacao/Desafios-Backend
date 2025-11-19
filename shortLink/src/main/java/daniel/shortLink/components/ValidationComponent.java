package daniel.shortLink.components;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ValidationComponent {
    public static boolean checkValidUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.headForHeaders(url);
            return true;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }
}
