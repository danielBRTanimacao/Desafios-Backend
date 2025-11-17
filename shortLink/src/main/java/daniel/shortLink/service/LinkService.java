package daniel.shortLink.service;

import daniel.shortLink.DTO.ResponseLinkDTO;
import daniel.shortLink.entity.LinkEntity;

import java.util.List;

public interface LinkService {
    List<LinkEntity> getAll();
    LinkEntity getLinkById(Long id);
    ResponseLinkDTO createLink(LinkEntity linkEntity);
}
