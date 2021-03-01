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
    @Enumerated
    private Country country;
    @Enumerated
    private Saleability saleability;
    private Boolean isEbook;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Price listPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Price retailPrice;
    private String buyLink;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Offer> offers;
}
