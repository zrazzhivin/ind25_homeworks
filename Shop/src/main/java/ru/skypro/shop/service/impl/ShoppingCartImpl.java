package ru.skypro.shop.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.skypro.shop.service.ShoppingCart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@SessionScope
public class ShoppingCartImpl implements ShoppingCart {

    private final Set<Integer> goods = new HashSet<>();

    @Override
    public List<Integer> add(List<Integer> goods) {
        this.goods.addAll(goods);
        return new ArrayList<>(this.goods);
    }

    @Override
    public List<Integer> get() {
        return new ArrayList<>(this.goods);
    }
}
