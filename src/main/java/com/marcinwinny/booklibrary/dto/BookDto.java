package com.marcinwinny.booklibrary.dto;

import com.marcinwinny.booklibrary.dto.accessinfodto.AccessInfoDto;
import com.marcinwinny.booklibrary.dto.saleinfodto.SaleInfoDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.VolumeInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfoDto volumeInfo;
    private SaleInfoDto saleInfo;
    private AccessInfoDto accessInfo;
    private SearchInfoDto searchInfo;
}
