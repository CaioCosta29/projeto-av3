package com.projeto_av3.projeto_av3.service;

import com.projeto_av3.projeto_av3.model.Endereco;
import com.projeto_av3.projeto_av3.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void salvarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }
}
