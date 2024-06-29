package ru.skypro.calculator.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.calculator.exception.DivideByZeroException;
import ru.skypro.calculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Integer plus(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    public Integer minus(Integer num1, Integer num2) {
        return num1 - num2;
    }

    @Override
    public Integer multiply(Integer num1, Integer num2) {
        return num1 * num2;
    }

    @Override
    public Integer divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new DivideByZeroException("Делить на ноль нельзя!");
        }

        return num1 / num2;
    }
}
