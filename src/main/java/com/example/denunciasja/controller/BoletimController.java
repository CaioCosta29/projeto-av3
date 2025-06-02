package com.example.denunciasja.controller;

import com.example.denunciasja.model.Boletim;
import com.example.denunciasja.model.Endereco;
import com.example.denunciasja.model.Usuario;
import com.example.denunciasja.service.BoletimService;
import com.example.denunciasja.service.EnderecoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class BoletimController {
    private final EnderecoService enderecoService;
    private final BoletimService boletimService;

    public BoletimController(EnderecoService enderecoService, BoletimService boletimService) {
        this.enderecoService = enderecoService;
        this.boletimService = boletimService;
    }

    @GetMapping("denuncias/boletim")
    public String boletim() {
        return "denuncias/boletim";
    }

    @PostMapping("denuncias/boletim/salvar")
    public String salvarBoletim(@RequestParam("dataHoraOcorrencia") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                    LocalDateTime dataHoraOcorrencia,
                                @RequestParam("nomeVitima") String nomeVitima,
                                @RequestParam("idadeVitima") Integer idadeVitima,
                                @RequestParam("cpfVitima") String cpfVitima,
                                @RequestParam("telefoneVitima") String telefoneVitima,
                                @RequestParam(value = "lesoesEvidencias", required = false) String lesoesEvidencias,
                                @RequestParam("descricaoFatos") String descricaoFatos,
                                @RequestParam("agressorArmado") boolean agressorArmado,
                                @RequestParam("vinculoAgressor") boolean vinculoAgressor,
                                @RequestParam("cep") String cep,
                                @RequestParam("logradouro") String logradouro,
                                @RequestParam("numeroEndereco") Integer numeroEndereco,
                                @RequestParam("bairro") String bairro,
                                @RequestParam("municipio") String municipio,
                                @RequestParam("estado") String estado,
                                @RequestParam("complementoEndereco") String complementoEndereco) {
        Endereco endereco = new Endereco(
                cep,
                logradouro,
                numeroEndereco.toString(),
                bairro,
                municipio,
                estado,
                complementoEndereco
        );

        endereco = enderecoService.salvarEndereco(endereco);

        Usuario usuario = (Usuario) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        Boletim boletim = new Boletim(usuario, dataHoraOcorrencia, nomeVitima, idadeVitima, cpfVitima, telefoneVitima, lesoesEvidencias, descricaoFatos, agressorArmado, vinculoAgressor, endereco);

        boletimService.salvarBoletim(boletim);


        return "redirect:/denuncias";
    }
}
