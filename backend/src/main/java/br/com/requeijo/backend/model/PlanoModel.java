package br.com.requeijo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanoModel {

    private Long id;
    private String nome;
    private double valor;
    private BeneficiarioModel beneficiario;
}
