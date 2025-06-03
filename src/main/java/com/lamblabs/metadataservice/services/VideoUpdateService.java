package com.lamblabs.metadataservice.services;

import com.lamblabs.metadataservice.dtos.EditVideoDTO;
import com.lamblabs.metadataservice.dtos.STATUS;
import com.lamblabs.metadataservice.jpa.entities.VideoEntity;
import com.lamblabs.metadataservice.jpa.repositories.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoUpdateService {

    private final VideoRepository videoRepository;

    @Transactional
    public void updateVideo(Long id, EditVideoDTO dto) {
        VideoEntity video = videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Video not found with id: " + id));

        if (dto.getDescription() != null) {
            video.setDescription(dto.getDescription());
        }
        if (dto.getTags() != null) {
            video.setTags(dto.getTags());
        }

        video.setStatus(STATUS.COMPLETED);

        videoRepository.save(video);
    }
}