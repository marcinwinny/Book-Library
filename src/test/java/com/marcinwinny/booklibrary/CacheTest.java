package com.marcinwinny.booklibrary;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.IndustryIdDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.VolumeInfoDto;
import com.marcinwinny.booklibrary.model.Book;
import com.marcinwinny.booklibrary.model.volumeinfo.Type;
import com.marcinwinny.booklibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@AllArgsConstructor
public class CacheTest {

    @Test
    public void whenCacheReachMaxSize_thenEviction() throws InterruptedException {
        CacheLoader<Long, BookDto> loader;
        loader = new CacheLoader<>() {
            @Override
            public BookDto load(Long key) throws Exception {
                BookDto bookDto = new BookDto();
                VolumeInfoDto volumeInfoDto = VolumeInfoDto.builder()
                        .id(key)
                        .build();
                bookDto.setVolumeInfo(volumeInfoDto);
                return bookDto;
            }
        };

        LoadingCache<Long, BookDto> cache;
        cache = CacheBuilder.newBuilder()
                .maximumSize(5)
                .build(loader);

        cache.getUnchecked(1L);
        cache.getUnchecked(2L);
        cache.getUnchecked(3L);
        cache.getUnchecked(4L);
        cache.getUnchecked(5L);
        cache.getUnchecked(6L);
        assertEquals(5, cache.size());
        assertNull(cache.getIfPresent(1L));
        assertNotNull(cache.getIfPresent(2L));
        assertNotNull(cache.getIfPresent(3L));
        assertNotNull(cache.getIfPresent(4L));
        assertNotNull(cache.getIfPresent(5L));
        assertNotNull(cache.getIfPresent(6L));
    }


}
