package com.marcinwinny.booklibrary.dto.volumeinfodto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingModesDto {
    private Long id;
    private Boolean text;
    private Boolean image;

    public ReadingModesDto(Boolean text, Boolean image) {
        this.text = text;
        this.image = image;
    }
}
