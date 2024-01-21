package com.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entities.PlayList;

public interface PlayListRepositiory extends JpaRepository<PlayList, Integer> {

}
