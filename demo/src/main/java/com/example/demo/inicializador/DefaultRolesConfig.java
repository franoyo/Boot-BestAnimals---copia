package com.example.demo.inicializador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.RolesModel;
import com.example.demo.repository.RolesRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Configuration
public class DefaultRolesConfig {
    
    private final RolesRepository rolesRepository;
     @Autowired
    public DefaultRolesConfig(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }
     @PostConstruct
    @Transactional
    public void init() {
        // Aquí defines tus roles por defecto
        createRoleIfNotExists("ADMIN");
        createRoleIfNotExists("USER");
        createRoleIfNotExists("VETERINARIO");
        createRoleIfNotExists("CAJA");
        createRoleIfNotExists("RECEPCIONISTA");
    }

    private void createRoleIfNotExists(String roleName) {
        if (rolesRepository.findByNombre(roleName) == null) {
            RolesModel role = new RolesModel();
            role.setNombre(roleName);
            rolesRepository.save(role);
        }
    }
}
