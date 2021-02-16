package com.autosearch.complete.service;

import com.autosearch.complete.dto.AutoSearchPostRequest;
import com.autosearch.complete.dto.AutoSearchResponse;
import reactor.core.publisher.Mono;

public interface AutoSearchService {
    AutoSearchResponse getSuggestions(String inputString);

    Mono<String> postSuggestion(AutoSearchPostRequest autoSearchPostRequest);
}
