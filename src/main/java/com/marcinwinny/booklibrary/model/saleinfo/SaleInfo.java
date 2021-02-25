package com.marcinwinny.booklibrary.model.saleinfo;

import com.marcinwinny.booklibrary.model.Country;

import java.util.List;

public class SaleInfo {
    private Country country;
    private Saleability saleability;
    private Boolean isEbook;
    private ListPrice listPrice;
    private RetailPrice retailPrice;
    private String buyLink;
    private List<Offer> offers;
}
