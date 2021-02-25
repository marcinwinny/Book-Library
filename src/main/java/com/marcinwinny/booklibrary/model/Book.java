package com.marcinwinny.booklibrary.model;

import com.marcinwinny.booklibrary.model.accesinfo.AccessInfo;
import com.marcinwinny.booklibrary.model.saleinfo.SaleInfo;
import com.marcinwinny.booklibrary.model.searchinfo.SearchInfo;
import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;
    private SaleInfo saleInfo;
    private AccessInfo accessInfo;
    private SearchInfo searchInfo;

}
