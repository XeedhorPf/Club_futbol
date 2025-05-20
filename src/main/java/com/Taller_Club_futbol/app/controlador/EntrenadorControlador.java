package com.Taller_Club_futbol.app.controlador;

import com.Taller_Club_futbol.app.entidades.Entrenador;
import com.Taller_Club_futbol.app.repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorControlador {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @GetMapping
    public String listarEntrenadores(Model model) {
        model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
        return "entrenadores/entrenadores";
    }

    @GetMapping("/nuevo")
    public String formularioNuevoEntrenador(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "entrenadores/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEntrenador(@ModelAttribute Entrenador entrenador) {
        entrenadorRepositorio.save(entrenador);
        return "redirect:/entrenadores";
    }

    @GetMapping("/editar/{id}")
    public String editarEntrenador(@PathVariable Long id, Model model) {
        Entrenador entrenador = entrenadorRepositorio.findById(id).orElse(null);
        model.addAttribute("entrenador", entrenador);
        return "entrenadores/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEntrenador(@PathVariable Long id) {
        entrenadorRepositorio.deleteById(id);
        return "redirect:/entrenadores";
    }
}