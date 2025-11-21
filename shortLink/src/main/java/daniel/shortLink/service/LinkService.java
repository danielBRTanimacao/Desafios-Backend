package daniel.shortLink.service;

import daniel.shortLink.utils.DTO.ResponseLinkDTO;
import daniel.shortLink.entity.LinkEntity;

import java.util.List;

public interface LinkService {
    List<LinkEntity> getAll();
    ResponseLinkDTO getLinkById(Long id);
    String accessUrlHash(String hash);
    ResponseLinkDTO createLink(LinkEntity linkEntity);
}
