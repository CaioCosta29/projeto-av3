package com.example.denunciasja.controller;

import com.example.denunciasja.model.Usuario;
import com.example.denunciasja.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "usuario/login";
    }

    @PostMapping("/entrar")
    public String login(@RequestParam String email,
                      @RequestParam String senha,
                      SecurityContext currentContext,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        Usuario usuario = usuarioService.carregarUsuarioPeloEmail(email);

        if (usuario == null || !usuarioService.verificarSenha(senha, usuario.getSenha())) {
            return "redirect:/login?error=true";
        }

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(usuario, null, authorities);

        currentContext.setAuthentication(authentication);

        SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
        securityContextRepository.saveContext(currentContext, request, response);

        return "redirect:/denuncias";
    }

    @GetMapping("/cadastrar")
    public String cadastro() {
        return "usuario/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam String nome,
                         @RequestParam String cpf,
                         @RequestParam String telefone,
                         @RequestParam String email,
                         @RequestParam String genero,
                         @RequestParam LocalDate dataNascimento,
                         @RequestParam String nomeContatoEmergencia,
                         @RequestParam String numeroContatoEmergencia,
                         @RequestParam String senha) {
        System.out.println("entrei aqui");
        Usuario usuario = new Usuario(cpf, nome, senha, telefone, genero, dataNascimento, email, nomeContatoEmergencia, numeroContatoEmergencia);
        usuarioService.salvarUsuario(usuario);

        return "redirect:/login";

    }
}
