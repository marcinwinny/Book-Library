package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.searchinfodto.SearchInfoDto;
import com.marcinwinny.booklibrary.model.searchinfo.SearchInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchInfoMapperTest {

    @Test
    void mapDtoToSearchInfo() {

        SearchInfoDto searchInfoDto = new SearchInfoDto();
        searchInfoDto.setTextSnippet("Lorem Ipsum");
        SearchInfo searchInfo = SearchInfoMapper.INSTANCE.mapDtoToSearchInfo(searchInfoDto);

        Assertions.assertNotNull(searchInfo);
        Assertions.assertEquals(searchInfoDto.getTextSnippet(), searchInfo.getTextSnippet());
    }
}