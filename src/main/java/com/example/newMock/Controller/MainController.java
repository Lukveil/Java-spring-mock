package com.example.newMock.Controller;


import com.example.newMock.Model.RequestDTO;
import com.example.newMock.Model.ResponseDTO;

import com.example.newMock.Controller.Helper.Currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;


@RestController
public class MainController {

    private final Logger log = LoggerFactory.getLogger(MainController.class);

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping(
            value = "/info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE, //producer
            consumes = MediaType.APPLICATION_JSON_VALUE // consumer

    )

    public Object postBalances(@RequestBody RequestDTO requestDTO) {
        try {

            int clientId = Integer.parseInt(String.valueOf(requestDTO.getClientId().charAt(0)));
            Currency currency;
            BigDecimal maxLimit;

            if (clientId == 8) {
                currency = Currency.US;
                maxLimit = new BigDecimal(2000);
            } else if (clientId == 9) {
                currency = Currency.EU;
                maxLimit = new BigDecimal(1000);
            } else {
                currency = Currency.RUB;
                maxLimit = new BigDecimal(10000);
            }

            ResponseDTO responseDTO = new ResponseDTO();

            responseDTO.setRqUID(requestDTO.getRqUID());
            responseDTO.setClientId(requestDTO.getClientId());
            responseDTO.setAccount(requestDTO.getAccount());
            responseDTO.setMaxLimit(maxLimit);
            responseDTO.setCurrency(currency);

            responseDTO.setBalance(new BigDecimal(String.valueOf(maxLimit)).
                    multiply(BigDecimal.valueOf(new Random().nextDouble())));

            log.info("*********** RequestDTO **********{}", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestDTO));
            log.info("*********** ResponseDTO **********{}", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDTO));

            return responseDTO;

        } catch (Exception e) {
            log.error("*********** Error **********");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
