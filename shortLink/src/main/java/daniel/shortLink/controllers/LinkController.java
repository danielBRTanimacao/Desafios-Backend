package daniel.shortLink.controllers;

import daniel.shortLink.DTO.RequestLinkDTO;
import daniel.shortLink.DTO.ResponseLinkDTO;
import daniel.shortLink.entity.LinkEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/link")
public interface LinkController {
    @GetMapping
    ResponseEntity<List<LinkEntity>> getAllLinks();
    @GetMapping
    ResponseEntity<LinkEntity> getSpecificLink(Long id);
    @PostMapping
    ResponseEntity<ResponseLinkDTO> createNewLink(RequestLinkDTO data);
}
