package ru.skypro.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.shop.service.ShopService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("order")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("add")
    public List<Integer> add(@RequestParam List<Integer> goods) {
        return shopService.add(goods);
    }

    @GetMapping("get")
    public List<Integer> get() {
        return shopService.get();
    }
}
