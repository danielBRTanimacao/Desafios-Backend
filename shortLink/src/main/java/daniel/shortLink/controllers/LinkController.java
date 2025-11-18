package daniel.shortLink.controllers;

import daniel.shortLink.DTO.RequestLinkDTO;
import daniel.shortLink.DTO.ResponseLinkDTO;
import daniel.shortLink.entity.LinkEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/link")
public interface LinkController {
    @GetMapping
    ResponseEntity<List<LinkEntity>> getAllLinks();
    @GetMapping("/{id}")
    ResponseEntity<ResponseLinkDTO> getSpecificLink(@PathVariable Long id);
    @PostMapping
    ResponseEntity<ResponseLinkDTO> createNewLink(@Valid @RequestBody RequestLinkDTO data);
}
