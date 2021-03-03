package com.marcinwinny.booklibrary.dto.accessinfodto;

import com.marcinwinny.booklibrary.model.Country;
import com.marcinwinny.booklibrary.model.accesinfo.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessInfoDto {
    private Long id;
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
