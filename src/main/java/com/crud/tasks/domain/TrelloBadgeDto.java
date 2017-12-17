package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBadgeDto {

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachmentsByType")
    private List<TrelloAttachmentByTypeDto> attachments;

}
