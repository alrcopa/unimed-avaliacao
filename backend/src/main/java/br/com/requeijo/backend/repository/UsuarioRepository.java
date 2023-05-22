package br.com.requeijo.backend.repository;

import br.com.requeijo.backend.model.Usuario;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UsuarioRepository {

    @Select("select * from usuario")
    List<Usuario> findAll();

    @Select("SELECT * FROM usuario WHERE id = #{id}")
    Usuario findById(long id);

    @Delete("DELETE FROM usuario WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO usuario(nome, login, senha) VALUES (#{nome}, #{login}, #{senha})")
    int insert(Usuario usuario);

    @Update("Update usuario set nome=#{nome}, login=#{login}, senha=#{senha} where id=#{id}")
    int update(Usuario usuario);

    @Select("SELECT * FROM usuario WHERE login = #{login}")
    Usuario findByLogin(String login);
}
