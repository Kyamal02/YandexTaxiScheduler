package com.itis.yandextaxischeduler.controller;

import com.itis.yandextaxischeduler.model.MomentPrice;
import com.itis.yandextaxischeduler.service.TaxiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PriceController {
    private final TaxiService taxiService;

    @GetMapping("/prices")
    public List<MomentPrice> getAllPrice() {
        return taxiService.getAllPrice();
    }
}
