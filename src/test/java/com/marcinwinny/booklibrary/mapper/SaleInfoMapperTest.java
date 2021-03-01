package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.saleinfodto.OfferDto;
import com.marcinwinny.booklibrary.dto.saleinfodto.PriceDto;
import com.marcinwinny.booklibrary.dto.saleinfodto.SaleInfoDto;
import com.marcinwinny.booklibrary.model.Country;
import com.marcinwinny.booklibrary.model.saleinfo.CurrencyCode;
import com.marcinwinny.booklibrary.model.saleinfo.SaleInfo;
import com.marcinwinny.booklibrary.model.saleinfo.Saleability;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaleInfoMapperTest {

    @Test
    void mapDtoToSaleInfo() {
        List<OfferDto> offers = new ArrayList<>();
        OfferDto offer = OfferDto.builder()
                .finskyOfferType(1L)
                .listPrice(PriceDto.builder().amountInMicros(7.9E7f).currencyCode("PLN").build())
                .retailPrice(PriceDto.builder().amountInMicros(5.53E7f).currencyCode("PLN").build())
                .build();
        offers.add(offer);

        SaleInfoDto saleInfoDto = SaleInfoDto.builder()
                .country("PL")
                .saleability("NOT_FOR_SALE")
                .isEbook(false)
                .listPrice(PriceDto.builder().amount(79.0f).currencyCode("PLN").build())
                .retailPrice(PriceDto.builder().amount(55.3f).currencyCode("PLN").build())
                .buyLink("XXX")
                .offers(offers)
                .build();
        SaleInfo saleInfo = SaleInfoMapper.INSTANCE.mapDtoToSaleInfo(saleInfoDto);

        Assertions.assertNotNull(saleInfo);
        Assertions.assertEquals(saleInfo.getCountry(), Country.PL);
        Assertions.assertEquals(saleInfo.getSaleability(), Saleability.NOT_FOR_SALE);
        Assertions.assertEquals(saleInfo.getIsEbook(), false);
        Assertions.assertEquals(saleInfo.getListPrice().getAmount(), 79.0f);
        Assertions.assertEquals(saleInfo.getListPrice().getCurrencyCode(), CurrencyCode.PLN);
        Assertions.assertEquals(saleInfo.getRetailPrice().getAmount(), 55.3f);
        Assertions.assertEquals(saleInfo.getRetailPrice().getCurrencyCode(), CurrencyCode.PLN);
        Assertions.assertEquals(saleInfo.getBuyLink(), "XXX");
    }

    @Test
    void mapDtoToPrice() {
    }

    @Test
    void mapDtoToOffer() {
    }
}