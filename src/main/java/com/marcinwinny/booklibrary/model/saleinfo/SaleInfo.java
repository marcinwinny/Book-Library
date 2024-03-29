package com.marcinwinny.booklibrary.model.saleinfo;

import com.marcinwinny.booklibrary.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private Saleability saleability;
    private Boolean isEbook;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_price")
    private Price listPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "retail_price")
    private Price retailPrice;
    private String buyLink;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Offer> offers;
}
