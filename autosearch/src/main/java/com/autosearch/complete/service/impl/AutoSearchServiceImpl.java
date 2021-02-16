package com.autosearch.complete.service.impl;

import com.autosearch.complete.constants.ErrorResponseConstants;
import com.autosearch.complete.dto.AutoSearchPostRequest;
import com.autosearch.complete.dto.AutoSearchResponse;
import com.autosearch.complete.exception.InvalidDataException;
import com.autosearch.complete.service.AutoSearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AutoSearchServiceImpl implements AutoSearchService {

    @Value("${search.min.character}")
    private String minCharacter;

    public Set<String> getStorageSet;

    public AutoSearchServiceImpl(){
        getStorageSet= new HashSet<>();
    }


    @Override
    public AutoSearchResponse getSuggestions(String inputString) {
        if(inputString.length() < Integer.parseInt(minCharacter)) throw new InvalidDataException(ErrorResponseConstants.INVALID_DATA_EXCEPTION);
        List<String> resultList=getStorageSet.stream().filter(suggestion->suggestion.contains(inputString)).collect(Collectors.toList());
        return AutoSearchResponse.builder().suggestions(resultList).build();
    }

    @Override
    public Mono<String> postSuggestion(AutoSearchPostRequest autoSearchPostRequest) {
        getStorageSet.addAll(autoSearchPostRequest.getSuggestionList());
        return Mono.just("Data saved successfully");
    }
}
