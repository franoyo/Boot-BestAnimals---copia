package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RolesModel;

@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Long> {
    public RolesModel findByNombre(String nombre);
}
