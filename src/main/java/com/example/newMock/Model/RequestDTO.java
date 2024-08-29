package com.example.newMock.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestDTO {
    private String rqUID;            // "58dgtf565j8547f64ke7",
    private String clientId;         //"3050000000000000000",
    private String account;         //"30500000000000000001",
    private Date openDate;        //"2020-01-01",
    private Date closeDate;       //"2025-01-01"

}
