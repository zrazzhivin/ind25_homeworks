package ru.skypro.shop.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.shop.service.ShopService;
import ru.skypro.shop.service.ShoppingCart;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShoppingCart shoppingCart;

    public ShopServiceImpl(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public List<Integer> add(List<Integer> goods) {
        return shoppingCart.add(goods);
    }

    @Override
    public List<Integer> get() {
        return shoppingCart.get();
    }
}
