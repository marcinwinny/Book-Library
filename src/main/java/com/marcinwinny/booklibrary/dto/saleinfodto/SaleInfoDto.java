package com.marcinwinny.booklibrary.dto.saleinfodto;

import com.marcinwinny.booklibrary.model.saleinfo.Saleability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleInfoDto {
    private String country;
    private String saleability;
    private Boolean isEbook;
    private PriceDto listPrice;
    private PriceDto retailPrice;
    private String buyLink;
    private List<OfferDto> offers;
}
