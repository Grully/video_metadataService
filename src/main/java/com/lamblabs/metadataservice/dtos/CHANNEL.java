package com.lamblabs.metadataservice.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum CHANNEL {
    @JsonProperty("telegram") TELEGRAM,
    @JsonProperty("instagram") INSTAGRAM,
    @JsonProperty("whatsapp") WHATSAPP
}