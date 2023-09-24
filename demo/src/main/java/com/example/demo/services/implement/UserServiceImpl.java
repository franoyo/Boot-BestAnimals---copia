package com.example.demo.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.RolesModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.RolesRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
      @Autowired
    private RolesRepository rolesRepository;
    // @Autowired
    //private PasswordEncoder passwordEncoder;
    @Override
    public UserModel guardarUsuario(UserModel usuario) {   
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();     
        RolesModel rolExistente = rolesRepository.findByNombre("USER");
        usuario.setRol(rolExistente);
        String contraseñaEncriptada =encoder.encode(usuario.getPassword());
        usuario.setPassword(contraseñaEncriptada);
        UserModel nuevo = userRepository.save(usuario);
        return nuevo;
    }

}
