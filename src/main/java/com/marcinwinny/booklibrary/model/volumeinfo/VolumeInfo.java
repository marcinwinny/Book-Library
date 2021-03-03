package com.marcinwinny.booklibrary.model.volumeinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VolumeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subtitle;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ElementCollection
    private List<Author> authors;
    private String publisher;
    private String publishedDate;
    @Column(length = 5000)
    private String description;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IndustryId> industryIdentifiers;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ReadingModes readingModes;
    private Long pageCount;
    @Enumerated(EnumType.STRING)
    private PrintType printType;
    @ElementCollection
    private List<String> categories;
    private Float averageRating;
    private Long ratingsCount;
    @Enumerated(EnumType.STRING)
    private MaturityRating maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;
}
