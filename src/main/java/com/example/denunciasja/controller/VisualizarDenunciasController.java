package com.example.denunciasja.controller;

import org.springframework.ui.Model;
import com.example.denunciasja.model.Boletim;
import com.example.denunciasja.model.Denuncia;
import com.example.denunciasja.model.Usuario;
import com.example.denunciasja.service.BoletimService;
import com.example.denunciasja.service.DenunciaService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VisualizarDenunciasController {
    private final DenunciaService denunciaService;
    private final BoletimService boletimService;

    public VisualizarDenunciasController(DenunciaService denunciaService, BoletimService boletimService) {
        this.denunciaService = denunciaService;
        this.boletimService = boletimService;
    }

    @GetMapping("/denuncias/visualizar")
    public String visualizarDenuncias(Model model) {
        Usuario usuarioLogado = (Usuario) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        List<Denuncia> denunciasRapidas = denunciaService.listarPorUsuario(usuarioLogado);

        List<Boletim> boletins = boletimService.listarPorUsuario(usuarioLogado);

        model.addAttribute("denunciasRapidas", denunciasRapidas);
        model.addAttribute("boletins", boletins);

        return "denuncias/visualizar-denuncias";
    }
}
