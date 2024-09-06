package org.example.dea2.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data // annotation that generates getters, setters, and other utility methods.
//define BidRequest class
public class BidApiRequest {

    private int userId;
    private int sellingId;
    private BigDecimal bidAmount;

}
