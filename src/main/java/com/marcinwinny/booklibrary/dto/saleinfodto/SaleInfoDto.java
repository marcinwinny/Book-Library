package com.marcinwinny.booklibrary.dto.saleinfodto;

import com.marcinwinny.booklibrary.model.saleinfo.Saleability;

import java.util.List;

public class SaleInfoDto {
    private String country;
    private String saleability;
    private Boolean isEbook;
    private PriceDto listPrice;
    private PriceDto retailPrice;
    private String buyLink;
    private List<OfferDto> offers;
}
