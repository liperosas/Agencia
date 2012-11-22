/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import classes.Curriculo;
import classes.InterfaceCurriculo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class RepositorioCurriculo extends Conexao implements InterfaceCurriculo {

    Statement conex;

    /**
     *
     * @param curriculo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void inserir(Curriculo curriculo) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "insert into curriculo(primeiro_nome, sobrenome, sexo, endereco, contato_fone, contato_email, contato_outras_info, experiencia_de_trabalho)";
        sql += "values('" + curriculo.getPrimeiroNome() + "','" + curriculo.getSobrenome() + "','" + curriculo.getSexo() + "','" + curriculo.getEndereco() + "','" + curriculo.getContatoFone() + "','" + curriculo.getContatoEmail() + "','" + curriculo.getContatoOutrasInfo() + "','" + curriculo.getExperienciaDeTrabalho() + "')";
        conex.execute(sql);
        desconectar();
    }

    /**
     *
     * @param cod
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void removerCur(int cod) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "delete from curriculo where curriculo_cod =" + cod;
        conex.execute(sql);
        desconectar();
    }

    /**
     *
     * @param curriculo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void alterarCur(Curriculo curriculo) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "update curriculo set primeiro_nome ='" + curriculo.getPrimeiroNome() + "', sobrenome ='" + curriculo.getSobrenome() + "', sexo='" + curriculo.getSexo() + "', endereco='" + curriculo.getEndereco() + "', contato_fone='" + curriculo.getContatoFone() + "', contato_email='" + curriculo.getContatoEmail() + "', contato_outras_info='" + curriculo.getContatoOutrasInfo() + "', experiencia_de_trabalho='" + curriculo.getExperienciaDeTrabalho() + "' where Curriculo_cod = " + curriculo.getCurriculoCod();
        conex.execute(sql);
        desconectar();
    }

    /**
     *
     * @param cod
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public Curriculo procurarCur(int cod) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "select curriculo_cod, primeiro_nome, sobrenome, sexo,  endereco,contato_fone, contato_email, contato_outras_info, experiencia_de_trabalho from Curriculo where curriculo_cod=" + cod;
        ResultSet rs = conex.executeQuery(sql);
        Curriculo curriculo = new Curriculo();
        while (rs.next()) {
            curriculo.setCurriculoCod(rs.getInt("curriculo_cod"));
            curriculo.setPrimeiroNome(rs.getString("primeiro_nome"));
            curriculo.setSobrenome(rs.getString("sobrenome"));
            curriculo.setSexo(rs.getString("sexo"));
            curriculo.setEndereco(rs.getString("endereco"));
            curriculo.setContatoFone(rs.getString("contato_fone"));
            curriculo.setContatoEmail(rs.getString("contato_email"));
            curriculo.setContatoOutrasInfo(rs.getString("contato_outras_info"));
            curriculo.setExperienciaDeTrabalho(rs.getString("experiencia_de_trabalho"));
        }
        desconectar();
        return curriculo;
    }

    /**
     *
     * @return @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public ArrayList<Curriculo> listarCur() throws SQLException, ClassNotFoundException {
        ArrayList<Curriculo> curriculos = new ArrayList<>();
        conex = conectar();
        String sql = "select curriculo_cod, primeiro_nome, sobrenome, sexo, contato_fone, contato_email, contato_outras_info, experiencia_de_trabalho, endereco from Curriculo";
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Curriculo curriculo = new Curriculo();
            curriculo.setCurriculoCod(rs.getInt("curriculo_cod"));
            curriculo.setPrimeiroNome(rs.getString("primeiro_nome"));
            curriculo.setSobrenome(rs.getString("sobrenome"));
            curriculo.setSexo(rs.getString("sexo"));
            curriculo.setContatoFone(rs.getString("contato_fone"));
            curriculo.setContatoEmail(rs.getString("contato_email"));
            curriculo.setContatoOutrasInfo(rs.getString("contato_outras_info"));
            curriculo.setExperienciaDeTrabalho(rs.getString("experiencia_de_trabalho"));
            curriculo.setEndereco(rs.getString("endereco"));
            curriculos.add(curriculo);
        }
        return curriculos;
    }
}
