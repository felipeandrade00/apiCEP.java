package org.aplicacao;

import org.aplicacao.dto.EnderecoDTO;
import org.aplicacao.servico.APIservico;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        APIservico apIservico = new APIservico();

        try {
            EnderecoDTO enderecoDTO = apIservico.getEndereco("64049484");
            System.out.println(enderecoDTO.getLogradouro());
            System.out.println("Bairro: " + enderecoDTO.getBairro());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}