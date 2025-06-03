package com.lamblabs.metadataservice.jpa.repositories;

import com.lamblabs.metadataservice.jpa.entities.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

}
