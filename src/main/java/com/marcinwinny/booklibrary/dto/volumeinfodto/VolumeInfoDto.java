package com.marcinwinny.booklibrary.dto.volumeinfodto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VolumeInfoDto {
    private Long id;
    private String title;
    private String subtitle;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private List<IndustryIdDto> industryIdentifiers;
    private ReadingModesDto readingModes;
    private Long pageCount;
    private String printType;
    private List<String> categories;
    private Float averageRating;
    private Long ratingsCount;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private ImageLinksDto imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;
}
