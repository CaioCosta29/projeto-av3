package com.example.denunciasja.service;

import com.example.denunciasja.model.Endereco;
import com.example.denunciasja.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }


}
