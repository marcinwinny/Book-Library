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

@Mapper(componentModel = "spring")
public interface SaleInfoMapper {

    SaleInfoMapper INSTANCE = Mappers.getMapper( SaleInfoMapper.class );

    @Mapping(target = "id", ignore = true)
    SaleInfo mapDtoToSaleInfo(SaleInfoDto saleInfoDto);

    @Mapping(target = "id", ignore = true)
    Price mapDtoToPrice(PriceDto priceDto);

    @Mapping(target = "id", ignore = true)
    Offer mapDtoToOffer(OfferDto offerDto);

}
