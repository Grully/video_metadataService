package com.lamblabs.metadataservice.services;

import com.lamblabs.metadataservice.jpa.entities.VideoEntity;
import com.lamblabs.metadataservice.jpa.repositories.VideoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoQueryService {
    private final VideoRepository videoRepository;

    @Transactional(readOnly = true)
    public List<VideoEntity> getVideosByUserId(Integer userId) {
        return videoRepository.findByUserId(userId);
    }
}
