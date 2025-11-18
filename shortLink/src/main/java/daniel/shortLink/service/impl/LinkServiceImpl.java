package daniel.shortLink.service.impl;

import daniel.shortLink.DTO.ResponseLinkDTO;
import daniel.shortLink.entity.LinkEntity;
import daniel.shortLink.exceptions.customs.NotFoundException;
import daniel.shortLink.repository.LinkRepository;
import daniel.shortLink.service.LinkService;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository repository;
    private final Hashids hashids;

    @Value("${app.domain}")
    private String domain;

    public LinkServiceImpl(LinkRepository repository, Hashids hashids) {
        this.repository = repository;
        this.hashids = hashids;
    }

    @Override
    public List<LinkEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseLinkDTO getLinkById(Long id) {
        LinkEntity foundUrl = repository.findById(id).orElseThrow(() -> new NotFoundException("Link with id " + id + " not found"));
        return new ResponseLinkDTO(foundUrl.getUrl());
    }

    @Override
    public ResponseLinkDTO createLink(LinkEntity linkEntity) {
        LinkEntity saved = repository.save(linkEntity);
        return new ResponseLinkDTO(domain + hashids.encode(saved.getId()));
    }
}
