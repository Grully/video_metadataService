package com.lamblabs.metadataservice.jpa.entities;

import com.lamblabs.metadataservice.dtos.CHANNEL;
import com.lamblabs.metadataservice.dtos.STATUS;
import com.lamblabs.metadataservice.jpa.converters.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Entity
@Table(name = "video_metadata")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VideoEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "user_id")
        private Integer userId;

        @Column(name = "channel")
        private CHANNEL channel;

        @Column(name = "status")
        private STATUS status;

        @Column(name = "tags")
        @Convert(converter = StringListConverter.class)
        private List<String> tags;

        @Column(name = "description")
        private String description;

        @Column(name = "path")
        private String path;

        @Column(name = "filename")
        private String filename;
}