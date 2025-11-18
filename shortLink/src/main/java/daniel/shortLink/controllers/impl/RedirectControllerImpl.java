package daniel.shortLink.controllers.impl;

import daniel.shortLink.controllers.RedirectController;
import daniel.shortLink.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class RedirectControllerImpl implements RedirectController {
    private final LinkService service;

    public RedirectControllerImpl(LinkService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<?> getAccessLink(String hash) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(service.accessUrlHash(hash)))
                .build();
    }
}
