package hexagonal.application.service;

import hexagonal.domain.SeriesEntity;
import hexagonal.adpters.outbound.repository.JpaSeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final JpaSeriesRepository seriesRepository;

    public List<SeriesEntity> findAllSeries() {
        return seriesRepository.findAll();
    }

    public void createSeries(SeriesEntity data) {
        seriesRepository.save(data);
    }

}
