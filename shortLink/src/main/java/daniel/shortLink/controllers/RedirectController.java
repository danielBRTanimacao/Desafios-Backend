package daniel.shortLink.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public interface RedirectController {
    @GetMapping("/{hash}")
    ResponseEntity<?> getAccessLink(@PathVariable String hash);
}
