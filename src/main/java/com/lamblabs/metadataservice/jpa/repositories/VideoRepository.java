package com.lamblabs.metadataservice.jpa.repositories;

import com.lamblabs.metadataservice.jpa.entities.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    List<VideoEntity> findByUserId(Integer userId);


}
