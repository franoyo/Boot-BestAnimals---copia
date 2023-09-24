package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class SimpleUserController {
@GetMapping("/inicio")
public String inicio(Model model){
return "userExternal/inicio";

}
@GetMapping("/info")
public String info(Model model){
return "userExternal/info";

}
@GetMapping("/servicios")
public String servicios(Model model){
return "userExternal/servicios";

}
@GetMapping("/guarderia")
public String guarderia(Model model){
return "userExternal/guarderia";

}
@GetMapping("/spa")
public String spa(Model model){
return "userExternal/spa";

}
@GetMapping("/viajar")
public String viaje(Model model){
return "userExternal/viaje";
}
@GetMapping("/consulta")
public String consulta(Model model){
return "userExternal/consulta";
}



}
