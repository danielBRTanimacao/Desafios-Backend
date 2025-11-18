package daniel.shortLink.service.impl;

import daniel.shortLink.DTO.ResponseLinkDTO;
import daniel.shortLink.entity.LinkEntity;
import daniel.shortLink.exceptions.customs.NotFoundException;
import daniel.shortLink.repository.LinkRepository;
import daniel.shortLink.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository repository;

    public LinkServiceImpl(LinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LinkEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public LinkEntity getLinkById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Link with id " + id + " not found"));
    }

    @Override
    public ResponseLinkDTO createLink(LinkEntity linkEntity) {
        return null;
    }
}
