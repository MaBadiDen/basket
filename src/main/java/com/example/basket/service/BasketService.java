package com.example.basket.service;

import com.example.basket.component.Basket;
import com.example.basket.sheet.Sheet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final Basket basket;
    private final Map<Integer, Sheet> sheets = Map.of(
            1, new Sheet("Колбаса", 200, 1),
            2, new Sheet("Трактор", 300, 2),
            3, new Sheet("Кабачок", 123, 3)
    );

    public BasketService(Basket basket) {
        this.basket = basket;
    }

    public void add(List<Integer> sheetIds) {
        basket.add(
                sheetIds.stream()
                        .map(sheets::get)
                        .collect(Collectors.toList())
        );
    }

    public List<Sheet> get() {
        return basket.get();
    }
}
