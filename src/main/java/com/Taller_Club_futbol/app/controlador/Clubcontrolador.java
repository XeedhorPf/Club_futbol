package com.Taller_Club_futbol.app.controlador;


import com.Taller_Club_futbol.app.entidades.Club;
import com.Taller_Club_futbol.app.repositorio.AsociacionRepositorio;
import com.Taller_Club_futbol.app.repositorio.ClubRepositorio;
import com.Taller_Club_futbol.app.repositorio.CompeticionRepositorio;
import com.Taller_Club_futbol.app.repositorio.EntrenadorRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/club")
public class Clubcontrolador {
    @Autowired
    private ClubRepositorio clubRepositorio;
    
    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;
    
    @Autowired
    private AsociacionRepositorio asociacionRepositorio;
    
    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    // 1. Mostrar lista de clubes
    @GetMapping
    public String listarClubes(Model model) {
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "club/clubes"; // → templates/clubes/lista.html
    }

    // 2. Mostrar formulario para nuevo club
    @GetMapping("/nuevo")
    public String formularioNuevoClub(Model model) {
        model.addAttribute("club", new Club());
        cargarDatosRelacionados(model);
        return "club/formulario";
    }

    // 3. Guardar club nuevo o actualizado
    @PostMapping("/guardar")
    public String guardarClub(@ModelAttribute Club club) {
        clubRepositorio.save(club);
        return "redirect:/club";
    }

    // 4. Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editarClub(@PathVariable Long id, Model model) {
        Club club = clubRepositorio.findById(id).orElse(null);
        model.addAttribute("club", club);
        cargarDatosRelacionados(model);
        return "club/formulario";
    }

    // 5. Eliminar club
    @GetMapping("/eliminar/{id}")
    public String eliminarClub(@PathVariable Long id) {
        clubRepositorio.deleteById(id);
        return "redirect:/club";
    }
    
    private void cargarDatosRelacionados(Model model) {
        model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
        model.addAttribute("asociaciones", asociacionRepositorio.findAll());
        model.addAttribute("competiciones", competicionRepositorio.findAll());
    }
}
