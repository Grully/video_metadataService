package com.lamblabs.metadataservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.List;

@Data
public class EditVideoDTO {

    @NotBlank(message = "Filename cannot be blank")
    private String filename;

    @Size(max = 1000, message = "Description cannot be longer than 1000 characters")
    private String description;

    @Size(max = 20, message = "Cannot have more than 20 tags")
    private List<@Size(max = 20, message = "Tag cannot be longer than 20 characters") String> tags;
    public EditVideoDTO(String filename, String description, List<@Size(max = 20, message = "Tag cannot be longer than 20 characters") String> tags) {
        this.filename = filename;
        this.description = description;
        this.tags = tags;
    }

}

