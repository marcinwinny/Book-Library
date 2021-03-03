package com.marcinwinny.booklibrary.model.accesinfo;

import com.marcinwinny.booklibrary.model.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private Viewability viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    @Enumerated(EnumType.STRING)
    private TextToSpeechPermission textToSpeechPermission;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Format epub;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Format pdf;
    private String webReaderLink;
    @Enumerated(EnumType.STRING)
    private AccessViewStatus accessViewStatus;
    private Boolean quoteSharingAllowed;
}
