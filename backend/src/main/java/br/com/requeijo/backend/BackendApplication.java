package br.com.requeijo.backend;

import br.com.requeijo.backend.model.Usuario;
import br.com.requeijo.backend.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BackendApplication implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsuarioRepository usuarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }


    @Override
    public void run(String... args) throws Exception {

        Usuario usuario = new Usuario(null, "admin", "admin", "admin");
        usuario.setSenha(getPasswordEncoder().encode(usuario.getSenha()));

        LOGGER.info("Inserting -> {}", usuarioRepository.insert(usuario));

        LOGGER.info("User id 1 -> {}", usuarioRepository.findById(1L));

        LOGGER.info("User login admin -> {}", usuarioRepository.findByLogin("admin"));

        LOGGER.info("All users -> {}", usuarioRepository.findAll());
    }

}
