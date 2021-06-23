package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.Intervention;

public interface InterventionRepository  extends JpaRepository<Intervention, Long>{
}