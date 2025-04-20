package com.projeto_av3.projeto_av3.controller;


import com.projeto_av3.projeto_av3.model.Endereco;
import com.projeto_av3.projeto_av3.model.Usuario;
import com.projeto_av3.projeto_av3.service.EnderecoService;
import com.projeto_av3.projeto_av3.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;

    public UsuarioController(UsuarioService usuarioService, EnderecoService enderecoService) {
        this.usuarioService = usuarioService;
        this.enderecoService = enderecoService;
    }

    @GetMapping("/cadastrar")
    public String criarConta() {
        return "usuario/cadastrar";
    }

    @GetMapping("/visualizar")
    public String visualizarConta(Model model) {
        model.addAttribute("usuarios", usuarioService.getAllUsuario());
        return "usuario/visualizar";
    }

    @PostMapping("/salvar")
    public String salvar(
            @RequestParam String nome,
            @RequestParam String cpf,
            @RequestParam String telefone,
            @RequestParam String genero,
            @RequestParam String dataNascimento,
            @RequestParam String email,
            @RequestParam String senha,

            @RequestParam String rua,
            @RequestParam String numero,
            @RequestParam String complemento,
            @RequestParam String cidade,
            @RequestParam String estado,
            @RequestParam String cep) {
        System.out.println(nome + cpf + telefone + genero + dataNascimento);
        Endereco endereco = new Endereco(rua, numero, complemento, estado, cidade, cep);



        LocalDate dt = LocalDate.parse(dataNascimento);

        Usuario usuario = new Usuario(cpf, nome, telefone, genero, senha, dt, email, endereco);

        enderecoService.salvarEndereco(endereco);
        usuarioService.salvarUsuario(usuario);
        return "redirect:/usuario/cadastrar";

    }
}
