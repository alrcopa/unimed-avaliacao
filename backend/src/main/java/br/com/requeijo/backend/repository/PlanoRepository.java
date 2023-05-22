package br.com.requeijo.backend.repository;

import br.com.requeijo.backend.model.BeneficiarioModel;
import br.com.requeijo.backend.model.PlanoModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlanoRepository {

    @Select("select * from plano ")
    @Results(value = {
            @Result(property = "beneficiario", column = "beneficiario_id", one=@One(select = "getBeneficiario"))
    })
    List<PlanoModel> findAll();

//    @Select("SELECT * FROM PLANO where nome like '% #{nome} %' ")
    @Select({"<script>",
            "SELECT * FROM plano WHERE upper(nome) like upper('%${nome}%') ",
            "</script>"})
    @Results(value = {
            @Result(property = "beneficiario", column = "beneficiario_id", one=@One(select = "getBeneficiario"))
    })
    List<PlanoModel> findByName(String nome);

    @Select("SELECT * FROM plano WHERE id = #{id}")
    PlanoModel findById(long id);

    @Insert("INSERT INTO plano(nome, valor, beneficiario_id) VALUES (#{nome}, #{valor}, #{beneficiario.id})")
    int insert(PlanoModel plano);

    @Update("Update plano set nome=#{nome}, valor=#{valor}, beneficiario_id=#{beneficiario.id} where id=#{id}")
    int update(PlanoModel plano);

    @Delete("DELETE FROM plano WHERE id = #{id}")
    int deleteById(long id);

    @Select("SELECT * FROM beneficiario WHERE id = #{id}")
    BeneficiarioModel getBeneficiario(long id);


}

