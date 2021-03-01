package com.marcinwinny.booklibrary.dto.saleinfodto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto {
    private Float amount;
    private Float amountInMicros;
    private String currencyCode;
}
