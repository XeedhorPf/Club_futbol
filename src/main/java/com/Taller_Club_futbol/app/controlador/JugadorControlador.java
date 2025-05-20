package com.Taller_Club_futbol.app.controlador;

import com.Taller_Club_futbol.app.entidades.Jugador;
import com.Taller_Club_futbol.app.repositorio.AsociacionRepositorio;
import com.Taller_Club_futbol.app.repositorio.ClubRepositorio;
import com.Taller_Club_futbol.app.repositorio.JugadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorControlador {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @Autowired
    private ClubRepositorio clubRepositorio;


    @Autowired
    private AsociacionRepositorio asociacionRepositorio;


    @GetMapping
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorRepositorio.findAll());
        return "jugadores/jugadores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioJugador(Model model) {
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("listaClubes", clubRepositorio.findAll());
        model.addAttribute("listaAsociaciones", asociacionRepositorio.findAll());
        return "jugadores/formulario";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        jugadorRepositorio.save(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editarJugador(@PathVariable Long id, Model model) {
        Jugador jugador = jugadorRepositorio.findById(id).orElse(null);
        model.addAttribute("jugador", jugador);
        model.addAttribute("listaClubes", clubRepositorio.findAll());
        model.addAttribute("listaAsociaciones", asociacionRepositorio.findAll());
        return "jugadores/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorRepositorio.deleteById(id);
        return "redirect:/jugadores";
    }
}
