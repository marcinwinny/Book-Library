package com.marcinwinny.booklibrary.config;

import com.google.common.cache.LoadingCache;
import com.marcinwinny.booklibrary.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CacheTest {

    @Autowired
    private LoadingCache<Long, BookDto> cache;

    @Test
    public void whenCacheReachMaxSize_thenEviction() {

        cache.getUnchecked(1L);
        cache.getUnchecked(2L);
        cache.getUnchecked(3L);
        cache.getUnchecked(4L);
        cache.getUnchecked(5L);
        cache.getUnchecked(6L);
        cache.getUnchecked(7L);
        assertEquals(5, cache.size());
        assertNull(cache.getIfPresent(1L));
        assertNull(cache.getIfPresent(2L));
        assertNotNull(cache.getIfPresent(3L));
        assertNotNull(cache.getIfPresent(4L));
        assertNotNull(cache.getIfPresent(5L));
        assertNotNull(cache.getIfPresent(6L));
        assertNotNull(cache.getIfPresent(7L));
        assertEquals(5, cache.size());
    }
}
