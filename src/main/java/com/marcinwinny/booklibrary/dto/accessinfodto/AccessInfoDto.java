package com.marcinwinny.booklibrary.dto.accessinfodto;

import com.marcinwinny.booklibrary.model.Country;
import com.marcinwinny.booklibrary.model.accesinfo.*;

public class AccessInfoDto {
    private String country;
    private String viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    private String textToSpeechPermission;
    private FormatDto epub;
    private FormatDto pdf;
    private String webReaderLink;
    private String accessViewStatus;
    private Boolean quoteSharingAllowed;
}