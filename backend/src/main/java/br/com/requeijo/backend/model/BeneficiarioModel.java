package br.com.requeijo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioModel {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private int idade;
}
