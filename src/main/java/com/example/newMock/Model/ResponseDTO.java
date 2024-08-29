package com.example.newMock.Model;
import java.math.BigDecimal;

import com.example.newMock.Controller.Helper.Currency;
import lombok.Data;


@Data
public class ResponseDTO {
    private String rqUID;                // "58dgtf565j8547f64ke7",
    private String clientId;         //"3050000000000000000",
    private String account;         //"30500000000000000001",
    private Currency currency;            //"RU",
    private BigDecimal balance;            //"16000.00",
    private BigDecimal maxLimit;           //"50000.00"
}
