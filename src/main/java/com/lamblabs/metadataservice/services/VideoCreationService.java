package com.lamblabs.metadataservice.services;

import com.lamblabs.metadataservice.dtos.NewVideoDTO;
import com.lamblabs.metadataservice.dtos.STATUS;
import com.lamblabs.metadataservice.jpa.entities.VideoEntity;
import com.lamblabs.metadataservice.jpa.repositories.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoCreationService {

    private final VideoRepository videoRepository;

    @Transactional
    public Long createVideo(NewVideoDTO dto) {
        VideoEntity video = new VideoEntity();
        video.setUserId(dto.getUserID());
        video.setChannel(dto.getChannel());
        video.setPath(dto.getPath());
        video.setStatus(STATUS.PROCESSING);
        video.setDescription("");
        video.setTags(List.of());

        VideoEntity savedVideo = videoRepository.save(video);
        return savedVideo.getId();
    }
}