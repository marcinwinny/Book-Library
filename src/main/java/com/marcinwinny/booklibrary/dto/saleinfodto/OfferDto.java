package com.marcinwinny.booklibrary.dto.saleinfodto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferDto {
    private Long id;
    private Long finskyOfferType;
    private PriceDto listPrice;
    private PriceDto retailPrice;
}
