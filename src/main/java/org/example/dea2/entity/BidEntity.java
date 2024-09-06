package org.example.dea2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
//define the BidEntity
public class BidEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int bidId;
    private int userId;
    private BigDecimal bidAmount;
    private int sellingId;
    private Date bidDate;

}
