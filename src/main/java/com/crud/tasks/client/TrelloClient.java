package com.crud.tasks.client;

import com.crud.tasks.controller.BoardNotFoundException;
import com.crud.tasks.domain.TrelloBoardDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.app.username}")
    private String trelloUser;

    @Autowired
    private RestTemplate restTemplate;

    public List<TrelloBoardDto> getTrelloBoards(){
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + trelloUser)
                    .queryParam("key", trelloAppKey)
                    .queryParam("token", trelloToken)
                    .queryParam("fields", "name,id").build().encode().toUri();

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);

        /*if(boardsResponse != null){
            return Arrays.asList(boardsResponse);
        }*/

        Optional<TrelloBoardDto[]> opt = Optional.of(boardsResponse);
        if(opt.isPresent()){
            return Arrays.asList(boardsResponse);
        }
        return  new ArrayList<>();
    }
}

