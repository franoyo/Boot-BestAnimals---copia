package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserModel;
import com.example.demo.services.IUserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IUserService interfazUsuario;
    @GetMapping("/login")
public String login(Model model){
return "auth/login";
}
   @GetMapping("/usuarioCreado")
public String userSucces(Model model){
return "alerts/usuario_creado";
}
@GetMapping("/registro")
public String Registro(Model model){
    UserModel userModel = new UserModel();

    // Agregar userModel al modelo
    model.addAttribute("userModel", userModel);
return "auth/registro";

}
@PostMapping("/guardarUsuario")
    public String saveUsuario(@Valid @ModelAttribute UserModel usuario, @RequestParam("password_confirmation") String pass,  BindingResult resultado) {

        if (resultado.hasErrors()) {
            return "/auth/registro";
        }
         if (!usuario.getPassword().equals(pass)) {
                resultado.rejectValue("password", "error.userModel", "Las contraseñas no coinciden");
                return "/auth/registro";
            }
        try {
        interfazUsuario.guardarUsuario(usuario);
        System.out.println("Usuario guardado con éxito");
        return "redirect:/auth/usuarioCreado";
    } catch (DataIntegrityViolationException e) {
        resultado.rejectValue("email", "error.email.duplicate", "El correo electrónico ya está en uso.");
        return "auth/registro";
    }
    }


}

