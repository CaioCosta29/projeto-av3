package com.example.denunciasja.controller;

import com.example.denunciasja.model.Denuncia;
import com.example.denunciasja.model.Usuario;
import com.example.denunciasja.service.DenunciaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class DenunciaRapidaController {
    private final DenunciaService denunciaService;

    public DenunciaRapidaController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    @GetMapping("denuncias/denuncia-rapida")
    public String denunciaRapida() {
        return "denuncias/denuncia";
    }

    @PostMapping("denuncias/denuncia-rapida/salvar")
    public String salvarDenunciaRapida(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data,
                                       @RequestParam("tipoViolencia") String tipoViolencia,
                                       @RequestParam("denuncianteEVitima") boolean denuncianteEVitima,
                                       @RequestParam("possuiVinculoAgressor") boolean possuiVinculoAgressor,
                                       @RequestParam("agressorArmado") boolean agressorArmado,
                                       @RequestParam("localizacao") String localizacao,
                                       @RequestParam("pontoReferencia") String pontoReferencia,
                                       @RequestParam("descricaoAgressor") String descricaoAgressor) {

        Usuario usuarioLogado = (Usuario) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        Denuncia denuncia = new Denuncia(
                usuarioLogado,
                data,
                tipoViolencia,
                denuncianteEVitima,
                possuiVinculoAgressor,
                agressorArmado,
                localizacao,
                pontoReferencia,
                descricaoAgressor
        );

        denunciaService.salvarDenuncia(denuncia);

        return "redirect:/denuncias";
    }
}
