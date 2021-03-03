package com.marcinwinny.booklibrary.dto.volumeinfodto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageLinksDto {
    private Long id;
    private String smallThumbnail;
    private String thumbnail;

    public ImageLinksDto(String smallThumbnail, String thumbnail) {
        this.smallThumbnail = smallThumbnail;
        this.thumbnail = thumbnail;
    }
}
