package com.lamblabs.metadataservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewVideoDTO {
    @NotNull(message = "User ID cannot be null")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "Channel cannot be null")
    private CHANNEL channel;

    @NotBlank(message = "Filename cannot be blank")
    private String filename;

    @NotBlank(message = "Path cannot be blank")
    private String path;
}