package com.marcinwinny.booklibrary.dto.saleinfodto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleInfoDto {
    private Long id;
    private String country;
    private String saleability;
    private Boolean isEbook;
    private PriceDto listPrice;
    private PriceDto retailPrice;
    private String buyLink;
    private List<OfferDto> offers;
}
