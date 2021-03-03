package com.marcinwinny.booklibrary.configuration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    private BookService bookService;

    public CacheConfig(@Lazy BookService bookService) {
        this.bookService = bookService;
    }

    @Bean
    public LoadingCache<Long, BookDto> loadingCache() {
        CacheLoader<Long, BookDto> loader;
        loader = new CacheLoader<>() {
            @Override
            public BookDto load(Long key) throws Exception {
                return bookService.getById(key);
            }
        };

        LoadingCache<Long, BookDto> cache;
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.MINUTES)
                .maximumSize(5)
                .build(loader);
        return cache;
    }
}
