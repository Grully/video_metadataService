package com.lamblabs.metadataservice.controllers;

import com.lamblabs.metadataservice.dtos.EditVideoDTO;
import com.lamblabs.metadataservice.dtos.NewVideoDTO;
import com.lamblabs.metadataservice.jpa.entities.VideoEntity;
import com.lamblabs.metadataservice.services.VideoCreationService;
import com.lamblabs.metadataservice.services.VideoQueryService;
import com.lamblabs.metadataservice.services.VideoUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video")
public class VideoController {
    private final VideoCreationService videoCreationService;
    private final VideoUpdateService videoUpdateService;
    private final VideoQueryService videoQueryService;

    @PostMapping
    public ResponseEntity<Map<String, Long>> createVideo(
            @RequestHeader("X-Request-ID") String requestId,
            @Valid @RequestBody NewVideoDTO dto) {
        // logging requestId TODO
        Long videoId = videoCreationService.createVideo(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("id", videoId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateVideo(
            @RequestHeader("X-Request-ID") String requestId,
            @PathVariable Long id,
            @Valid @RequestBody EditVideoDTO dto) {
        if (!id.equals(dto.getVideoId())) {
            throw new IllegalArgumentException("Path ID and body video_id must match");
        }
        videoUpdateService.updateVideo(id, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<VideoEntity>> getVideosByUserId(@PathVariable Integer userId) {
        List<VideoEntity> videos = videoQueryService.getVideosByUserId(userId);
        return ResponseEntity.ok(videos);
    }
}