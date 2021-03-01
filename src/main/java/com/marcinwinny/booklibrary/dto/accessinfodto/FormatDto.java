package com.marcinwinny.booklibrary.dto.accessinfodto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormatDto {
    private Boolean isAvailable;
    private String acsTokenLink;
}
