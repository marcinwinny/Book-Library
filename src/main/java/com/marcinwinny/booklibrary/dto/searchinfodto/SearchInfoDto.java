package com.marcinwinny.booklibrary.dto.searchinfodto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchInfoDto {
    private Long id;
    private String textSnippet;
}
