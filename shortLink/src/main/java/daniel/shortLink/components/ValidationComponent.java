package daniel.shortLink.components;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ValidationComponent {
    public static void checkValidUrl(String url) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForEntity(url, String.class).getStatusCode());
    }
}
