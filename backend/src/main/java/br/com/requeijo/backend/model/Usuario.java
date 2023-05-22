package br.com.requeijo.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private Long id;
    private String nome;
    private String login;
    private String senha;

}


