package com.marcinwinny.booklibrary.dto.accessinfodto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormatDto {
    private Long id;
    private Boolean isAvailable;
    private String acsTokenLink;

    public FormatDto(Boolean isAvailable, String acsTokenLink) {
        this.isAvailable = isAvailable;
        this.acsTokenLink = acsTokenLink;
    }
}
