package com.marcinwinny.booklibrary.model.accesinfo;

import com.marcinwinny.booklibrary.model.Country;

public class AccessInfo {
    private Country country;
    private Viewability viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    private TextToSpeechPermission textToSpeechPermission;
    private Format epub;
    private Format pdf;
    private String webReaderLink;
    private AccessViewStatus accessViewStatus;
    private Boolean quoteSharingAllowed;
}
