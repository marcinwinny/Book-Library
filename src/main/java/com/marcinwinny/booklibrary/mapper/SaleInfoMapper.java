package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.saleinfodto.OfferDto;
import com.marcinwinny.booklibrary.dto.saleinfodto.PriceDto;
import com.marcinwinny.booklibrary.dto.saleinfodto.SaleInfoDto;
import com.marcinwinny.booklibrary.model.saleinfo.Offer;
import com.marcinwinny.booklibrary.model.saleinfo.Price;
import com.marcinwinny.booklibrary.model.saleinfo.SaleInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleInfoMapper {

    SaleInfoMapper INSTANCE = Mappers.getMapper( SaleInfoMapper.class );

    SaleInfo mapDtoToSaleInfo(SaleInfoDto saleInfoDto);

    Price mapDtoToPrice(PriceDto priceDto);

    Offer mapDtoToOffer(OfferDto offerDto);

}
