package com.marcinwinny.booklibrary.model;

import com.marcinwinny.booklibrary.model.accesinfo.AccessInfo;
import com.marcinwinny.booklibrary.model.saleinfo.SaleInfo;
import com.marcinwinny.booklibrary.model.searchinfo.SearchInfo;
import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_id")
    private String bookId;
    private String kind;
    private String etag;
    private String selfLink;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private VolumeInfo volumeInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private SaleInfo saleInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private AccessInfo accessInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private SearchInfo searchInfo;

}
