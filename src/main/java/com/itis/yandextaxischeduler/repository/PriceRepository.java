package com.itis.yandextaxischeduler.repository;

import com.itis.yandextaxischeduler.model.MomentPrice;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PriceRepository extends CrudRepository<MomentPrice, Long> {
    @Timed("gettingAllPrices")
    List<MomentPrice> findAll();
}
