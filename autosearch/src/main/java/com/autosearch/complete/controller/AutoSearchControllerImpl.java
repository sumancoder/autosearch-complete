package com.autosearch.complete.controller;

import com.autosearch.complete.dto.AutoSearchPostRequest;
import com.autosearch.complete.dto.AutoSearchResponse;
import com.autosearch.complete.service.AutoSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@RestController
public class AutoSearchControllerImpl implements AutoSearchController {

    @Autowired
    AutoSearchService autoSearchService;


    public AutoSearchResponse getSuggestions(String inputString){
        return autoSearchService.getSuggestions(inputString);
    }

    @Override
    public Mono<String> createSuggestions(AutoSearchPostRequest autoSearchPostRequest) {
        return autoSearchService.postSuggestion(autoSearchPostRequest);
    }
}
