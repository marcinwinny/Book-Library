package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.accessinfodto.AccessInfoDto;
import com.marcinwinny.booklibrary.dto.accessinfodto.FormatDto;
import com.marcinwinny.booklibrary.model.Country;
import com.marcinwinny.booklibrary.model.accesinfo.AccessInfo;
import com.marcinwinny.booklibrary.model.accesinfo.AccessViewStatus;
import com.marcinwinny.booklibrary.model.accesinfo.TextToSpeechPermission;
import com.marcinwinny.booklibrary.model.accesinfo.Viewability;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccessInfoMapperTest {

    @Test
    void mapDtoToAccessInfo() {
        AccessInfoDto accessInfoDto = AccessInfoDto.builder()
                .country("PL")
                .viewability("PARTIAL")
                .embeddable(true)
                .publicDomain(false)
                .textToSpeechPermission("ALLOWED")
                .epub(new FormatDto(true, "tokenlink"))
                .pdf(new FormatDto(true, "tokenlink"))
                .webReaderLink("webReaderLink")
                .accessViewStatus("SAMPLE")
                .quoteSharingAllowed(false)
                .build();
        AccessInfo accessInfo = AccessInfoMapper.INSTANCE.mapDtoToAccessInfo(accessInfoDto);

        Assertions.assertNotNull(accessInfo);
        Assertions.assertEquals(accessInfo.getCountry(), Country.PL);
        Assertions.assertEquals(accessInfo.getViewability(), Viewability.PARTIAL);
        Assertions.assertEquals(accessInfo.getEmbeddable(), true);
        Assertions.assertEquals(accessInfo.getPublicDomain(), false);
        Assertions.assertEquals(accessInfo.getTextToSpeechPermission(), TextToSpeechPermission.ALLOWED);
        Assertions.assertEquals(accessInfo.getEpub().getIsAvailable(), true);
        Assertions.assertEquals(accessInfo.getEpub().getAcsTokenLink(), "tokenlink");
        Assertions.assertEquals(accessInfo.getPdf().getIsAvailable(), true);
        Assertions.assertEquals(accessInfo.getPdf().getAcsTokenLink(), "tokenlink");
        Assertions.assertEquals(accessInfo.getWebReaderLink(), "webReaderLink");
        Assertions.assertEquals(accessInfo.getAccessViewStatus(), AccessViewStatus.SAMPLE);
        Assertions.assertEquals(accessInfo.getQuoteSharingAllowed(), false);
    }

}