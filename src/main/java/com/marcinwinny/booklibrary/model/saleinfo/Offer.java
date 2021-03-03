package com.marcinwinny.booklibrary.model.saleinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long finskyOfferType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Price listPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Price retailPrice;
}
