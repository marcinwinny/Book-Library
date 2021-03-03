package com.marcinwinny.booklibrary.dto.volumeinfodto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private Double averageRating;
}
