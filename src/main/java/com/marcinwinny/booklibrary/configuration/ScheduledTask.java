package com.marcinwinny.booklibrary.configuration;

import com.google.common.cache.LoadingCache;
import com.marcinwinny.booklibrary.dto.BookDto;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScheduledTask {

    private final LoadingCache<Long, BookDto> cache;

    //execute every 60 minutes = 3 600 000 milliseconds
    @Scheduled(fixedRate = 3600000)
    public void invalidateAllCache() {
        cache.invalidateAll();
    }
}
