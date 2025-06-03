package com.lamblabs.metadataservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
public class EditVideoDTO {
    @NotNull(message = "Video ID cannot be null")
    @JsonProperty("video_id")
    private Long videoId;

    @Size(max = 500, message = "Description too long")
    private String description;

    @Size(max = 20, message = "Too many tags")
    private List<@Size(max = 30, message = "Tag too long") String> tags;
}