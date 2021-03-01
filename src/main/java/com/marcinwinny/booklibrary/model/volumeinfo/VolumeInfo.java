package com.marcinwinny.booklibrary.model.volumeinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
//    private LocalDate publishedDate;
    @Column(length = 5000)
    private String description;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IndustryId> industryIdentifiers;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ReadingModes readingModes;
    private Long pageCount;
    @Enumerated
    private PrintType printType;
    @ElementCollection
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<String> categories;
    private Float averageRating;
    private Long ratingsCount;
    @Enumerated
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
