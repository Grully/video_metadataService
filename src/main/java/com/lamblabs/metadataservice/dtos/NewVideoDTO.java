package com.lamblabs.metadataservice.dtos;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.*;
@Data
@AllArgsConstructor
public class NewVideoDTO {
    private int userID;

    @NotNull(message = "Channel cannot be null")
    private CHANNEL channel;

    @NotBlank(message = "Filename cannot be blank")
    private String filename;


    @NotBlank(message = "Path cannot be blank")
    private String path;
}