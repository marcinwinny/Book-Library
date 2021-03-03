package com.marcinwinny.booklibrary.dto.volumeinfodto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndustryIdDto {
    private Long id;
    private String type;
    private String identifier;

    public IndustryIdDto(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }
}
