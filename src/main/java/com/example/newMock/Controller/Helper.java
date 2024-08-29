package com.example.newMock.Controller;

import lombok.Getter;

public class Helper {

    @Getter
    public enum Currency {
        EU("EU"),
        US("US"),
        RUB("RUB");
        private final String description;

        // Конструктор перечисления
        Currency(String description) {
            this.description = description;
        }

    }
}
