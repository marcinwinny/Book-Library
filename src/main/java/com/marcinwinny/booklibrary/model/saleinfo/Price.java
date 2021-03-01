package com.marcinwinny.booklibrary.model.saleinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Float amount;
    @Column
    private Float amountInMicros;
    @Column
    @Enumerated
    private CurrencyCode currencyCode;
}
