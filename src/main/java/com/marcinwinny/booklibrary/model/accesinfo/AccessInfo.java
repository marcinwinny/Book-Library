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
    @Enumerated
    private Country country;
    @Enumerated
    private Viewability viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    @Enumerated
    private TextToSpeechPermission textToSpeechPermission;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Format epub;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Format pdf;
    private String webReaderLink;
    @Enumerated
    private AccessViewStatus accessViewStatus;
    private Boolean quoteSharingAllowed;
}
