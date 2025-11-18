package daniel.shortLink.controllers.impl;

import daniel.shortLink.DTO.RequestLinkDTO;
import daniel.shortLink.DTO.ResponseLinkDTO;
import daniel.shortLink.controllers.LinkController;
import daniel.shortLink.entity.LinkEntity;
import daniel.shortLink.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class LinkControllerImpl implements LinkController {

    private final LinkService service;

    public LinkControllerImpl(LinkService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<LinkEntity>> getAllLinks() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Override
    public ResponseEntity<ResponseLinkDTO> getSpecificLink(Long id) {
        return ResponseEntity.ok().body(service.getLinkById(id));
    }

    @Override
    public ResponseEntity<ResponseLinkDTO> createNewLink(RequestLinkDTO data) {
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setUrl(data.url());
        return new ResponseEntity<>(service.createLink(linkEntity), HttpStatus.CREATED);
    }
}
