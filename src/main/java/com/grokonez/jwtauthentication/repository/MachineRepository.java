package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grokonez.jwtauthentication.entitys.Machine;

public interface MachineRepository  extends JpaRepository<Machine, Long>{


}