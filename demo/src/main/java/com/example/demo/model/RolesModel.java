package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class RolesModel implements Serializable {
 @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_rol;
    @Column(length = 30, nullable = false)
    private String nombre;
    


    
}
