package br.com.requeijo.backend.repository;

import br.com.requeijo.backend.model.PlanoModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PlanoRepository {

    @Select("SELECT * FROM plano")
    List<PlanoModel> findAll();

    @Select({"<script>",
            "SELECT * FROM plano WHERE upper(nome) like upper('%${nome}%') ",
            "</script>"})
    List<PlanoModel> findByName(String nome);

    @Select("SELECT * FROM plano WHERE id = #{id}")
    PlanoModel findById(long id);

    @Insert("INSERT INTO plano(nome, valor) VALUES (#{nome}, #{valor})")
    int insert(PlanoModel plano);

    @Update("Update plano set nome=#{nome}, valor=#{valor} where id=#{id}")
    int update(PlanoModel plano);

    @Delete("DELETE FROM plano WHERE id = #{id}")
    int deleteById(long id);



}

