package com.marcinwinny.booklibrary.model.volumeinfo;

import java.time.LocalDate;
import java.util.List;

public class VolumeInfo {

    private String title;
    private String subtitle;
    private List<String> authors;
    private String publisher;
    //TODO: Decide what type to use
    private LocalDate publishedDate;
    private String description;
    private List<IndustryId> industryIdentifiers;
    private ReadingModes readingModes;
    private Long pageCount;
    private PrintType printType;
    private List<String> categories;
    private Float averageRating;
    private Long ratingsCount;
    private MaturityRating maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;

}
