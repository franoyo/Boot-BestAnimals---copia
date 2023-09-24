
package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;  // Cambiado a tipo de dato Long
    @Column(length = 30, nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
     @Size(min = 3, max = 255, message = "El nombre debe tener al menos 3 caracteres")
     @Pattern(
        regexp = "^[\\pL\\s\\-]+$",
        message = "El Nombre solo acepta letras"
    )
    private String nombre;
    @NotBlank(message = "El Apellido es obligatorio")
     @Size(min = 3,max = 255, message = "El Apellido debe tener al menos 3 caracteres")
     @Pattern(
    regexp = "^[\\pL\\s\\-]+$",
    message = "El Apellido solo acepta letras"
)
    @Column(length = 30, nullable = false)
    private String apellido;
     @NotBlank(message = "La direccion es obligatoria")
     @Size(min = 8,max = 255, message = "la direccion debe tener al menos 8 caracteres")
    @Column(length = 30, nullable = false)
    private String direccion;
    @NotBlank(message = "El Celular es Obligatorio")
     @Size(min = 8,max = 255, message = "El Celular debe tener al menos 8 caracteres")
    @Column(length = 30, nullable = false)
    private String celular;
     @NotBlank(message = "El Documento es Obligatorio")
     @Size(min = 8,max = 255, message = "El Documento debe tener al menos 8 caracteres")
    @Column(length = 30, nullable = false)
    private String documento;

    @Pattern(
        regexp = "^.+@.+\\.[A-Za-z]{2,}$",
    message = "El correo electrónico no tiene un formato válido"
)
    @Size(min = 6, max = 255, message = "El Email debe tener al menos 6 caracteres")
    
    @Column(length = 30, nullable = false, unique=true)
    private String email;
    @Column(length = 255, nullable = false)
    private String password;
 @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id", referencedColumnName = "id_rol")
    private RolesModel rol;
}
