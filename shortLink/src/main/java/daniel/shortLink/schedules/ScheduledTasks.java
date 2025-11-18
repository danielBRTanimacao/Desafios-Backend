package daniel.shortLink.schedules;

import daniel.shortLink.repository.LinkRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final LinkRepository linkRepository;

    public ScheduledTasks(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void urlChecker() {
        linkRepository.findAll().forEach(link -> {
            if (link.isExpired()) {
                linkRepository.delete(link);
            }
        });
    }
}
