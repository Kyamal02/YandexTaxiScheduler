package com.itis.yandextaxischeduler.scheduler;

import com.itis.yandextaxischeduler.model.Coordinate;
import com.itis.yandextaxischeduler.properties.CoordinateProperties;
import com.itis.yandextaxischeduler.service.TaxiService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YandexScheduler {
    private final CoordinateProperties coordinateProperties;
    private final TaxiService taxiService;

    @Timed("schedulerTaxi")
    @Scheduled(fixedDelay = 30_000)
    public void updatePrice() {
        Coordinate startPoint = new Coordinate(coordinateProperties.getStartLatitude(), coordinateProperties.getStartLongitude());
        Coordinate endPoint = new Coordinate(coordinateProperties.getFinishLatitude(), coordinateProperties.getFinishLongitude());
        taxiService.getPrice(startPoint, endPoint);
    }
}
