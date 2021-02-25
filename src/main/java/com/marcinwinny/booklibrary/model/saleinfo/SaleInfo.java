package com.marcinwinny.booklibrary.model.saleinfo;

import com.marcinwinny.booklibrary.model.Country;

import java.util.List;

public class SaleInfo {
    private Country country;
    private Saleability saleability;
    private Boolean isEbook;
    private Price listPrice;
    private Price retailPrice;
    private String buyLink;
    private List<Offer> offers;
}
