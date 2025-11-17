package daniel.shortLink.controllers.impl;

import daniel.shortLink.DTO.RequestLinkDTO;
import daniel.shortLink.DTO.ResponseLinkDTO;
import daniel.shortLink.controllers.LinkController;
import daniel.shortLink.entity.LinkEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkControllerImpl implements LinkController {

    @Override
    public ResponseEntity<List<LinkEntity>> getAllLinks() {
        return null;
    }

    @Override
    public ResponseEntity<LinkEntity> getSpecificLink(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseLinkDTO> createNewLink(RequestLinkDTO data) {
        return null;
    }
}
