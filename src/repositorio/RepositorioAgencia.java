/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import classes.Agencia;
import classes.Categoria;
import classes.InterfaceAgencia;
import classes.Vaga;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lipe
 */
public class RepositorioAgencia extends Conexao implements InterfaceAgencia {

    Statement conex;

    /**
     *
     * @param agencia
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void inserirAg(Agencia agencia) throws SQLException, ClassNotFoundException {

        conex = conectar();
        String sql = "insert into agencia(ag_nome, ag_endereco, ag_fone, ag_email, ag_outras_info)";
        sql += "values('" + agencia.getAg_nome() + "','" + agencia.getAg_endereco() + "','" + agencia.getAg_fone() + "','" + agencia.getAg_email() + "','" + agencia.getAg_outras_info() + "')";
        conex.execute(sql);
        sql = "select MAX(Ag_Cod) as Ag_Cod from agencia";
        ResultSet rs = conex.executeQuery(sql);
        int cod = 0;
        while (rs.next()) {
            cod = rs.getInt("Ag_Cod");
        }
        for (int i = 0; i < agencia.getCategorias().size(); i++) {
            sql = "insert into categorias_da_agencia (ag_cod, cat_ag_cod) values (" + cod + ", " + agencia.getCategorias().get(i).getCat_cod() + ")";
            conex.execute(sql);
        }

        desconectar();
    }

    /**
     *
     * @param cod
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void removerAg(int cod) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql2 = "delete from categorias_da_agencia where Ag_Cod = " + cod;
        conex.execute(sql2);
        String sql = "delete from agencia where ag_cod =" + cod;
        conex.execute(sql);
        desconectar();
    }

    /**
     *
     * @param agencia
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void alterarAg(Agencia agencia) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "update agencia set ag_nome ='" + agencia.getAg_nome() + "', ag_endereco ='" + agencia.getAg_endereco() + "', ag_fone='" + agencia.getAg_fone() + "', ag_email='" + agencia.getAg_email() + "', ag_outras_info='" + agencia.getAg_outras_info() + "' where ag_cod=" + agencia.getAg_cod();
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
    public Agencia procurarAg(int cod) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "select ag_cod, ag_nome, ag_endereco, ag_fone,  ag_email, ag_outras_info from agencia where ag_cod=" + cod;
        ResultSet rs = conex.executeQuery(sql);
        Agencia agencia = new Agencia();
        while (rs.next()) {
            agencia.setAg_cod(rs.getInt("ag_cod"));
            agencia.setAg_nome(rs.getString("ag_nome"));
            agencia.setAg_endereco(rs.getString("ag_endereco"));
            agencia.setAg_fone(rs.getString("ag_fone"));
            agencia.setAg_email(rs.getString("ag_email"));
            agencia.setAg_outras_info(rs.getString("ag_outras_info"));
        }
        desconectar();
        return agencia;
    }

    public ArrayList<Categoria> listarCatAg(int cod) throws SQLException, ClassNotFoundException {
        ArrayList<Categoria> categorias = new ArrayList<>();
        conex = conectar();
        String sql = "select CAT_AG_COD FROM CATEGORIAS_DA_AGENCIA WHERE AG_COD = " + cod;
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setCat_cod(rs.getInt("cat_ag_cod"));
            categorias.add(categoria);
        }
        return categorias;
    }

    @Override
    public ArrayList<Agencia> listarAg(Agencia filtro) throws SQLException, ClassNotFoundException {
        ArrayList<Agencia> agencias = new ArrayList<>();
        conex = conectar();
        String sql = "select ag_cod, ag_nome, ag_endereco, ag_fone, ag_email, ag_outras_info from agencia where ag_cod=ag_cod ";
        if (filtro.getAg_nome() != null && filtro.getAg_nome().equals("") == false) {
            sql += " and ag_nome like '%" + filtro.getAg_nome() + "%'";
        }
        if (filtro.getAg_cod() != 0) {
            sql += "and ag_cod like '%" + filtro.getAg_cod() + "'%";
        }        
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Agencia agencia = new Agencia();
            agencia.setAg_cod(rs.getInt("ag_cod"));
            agencia.setAg_nome(rs.getString("ag_nome"));
            agencia.setAg_endereco(rs.getString("ag_endereco"));
            agencia.setAg_fone(rs.getString("ag_fone"));
            agencia.setAg_email(rs.getString("ag_email"));
            agencia.setAg_outras_info(rs.getString("ag_outras_info"));
            agencias.add(agencia);
        }
        return agencias;
    }
    //igor
    public ArrayList<Agencia> listarNomeAg(String filtro) throws SQLException, ClassNotFoundException {
        ArrayList<Agencia> agencias = new ArrayList<>();
        conex = conectar();
        String sql = "select ag_cod, ag_nome, ag_endereco, ag_fone, ag_email, ag_outras_info from agencia where ag_cod=ag_cod and ag_nome like '%"+filtro+"%'";
          
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Agencia agencia = new Agencia();
            agencia.setAg_cod(rs.getInt("ag_cod"));
            agencia.setAg_nome(rs.getString("ag_nome"));
            agencia.setAg_endereco(rs.getString("ag_endereco"));
            agencia.setAg_fone(rs.getString("ag_fone"));
            agencia.setAg_email(rs.getString("ag_email"));
            agencia.setAg_outras_info(rs.getString("ag_outras_info"));
            agencias.add(agencia);
        }
        return agencias;
    }

    public void alterarCategoriaAgencia(int codigoAgencia, int codigoCategoria, int novoCodigoCategoria) throws ClassNotFoundException, SQLException {
        conex = conectar();
        String sql = "delete from categorias_da_agencia where ag_cod=" + codigoAgencia + " and cat_ag_cod = " + codigoCategoria;
        conex.execute(sql);
        sql = "insert into categorias_da_agencia (ag_cod, cat_ag_cod) values (" + codigoAgencia + " , " + novoCodigoCategoria + " );";
        conex.execute(sql);
        desconectar();
    }

    public void cadastrarCategoriaAgencia(int codigoAgencia, int codigoCategoria) throws ClassNotFoundException, SQLException {
        conex = conectar();
        String sql = "insert into categorias_da_agencia (ag_cod, cat_ag_cod) values (" + codigoAgencia + " , " + codigoCategoria + ");";
        conex.execute(sql);
        desconectar();
    }

    public void removerCategoriaAgencia(int codigoAgencia, int codigoCategoria) throws ClassNotFoundException, SQLException {
        conex = conectar();
        String sql = "delete from categorias_da_agencia where ag_cod=" + codigoAgencia + " and cat_ag_cod = " + codigoCategoria;
        conex.execute(sql);
        desconectar();
    }

    public Categoria verificarCat(int codigoAgencia, int codigoCategoria) throws ClassNotFoundException, SQLException {
        conex = conectar();
        String sql = "select cat_ag_cod from categorias_da_agencia where cat_ag_cod = " + codigoCategoria + " and ag_cod=" + codigoAgencia + ";";
        ResultSet rs = conex.executeQuery(sql);
        Categoria cat = new Categoria();
        while (rs.next()) {
            cat.setCat_cod(rs.getInt("cat_ag_cod"));
        }
        return cat;
    }

    public ArrayList<Vaga> vagasAgencia(int codigoAgencia) throws ClassNotFoundException, SQLException {
        ArrayList<Vaga> vagas = new ArrayList<>();
        conex = conectar();
        String sql = "SELECT VAGA_COD FROM VAGA WHERE AG_COD = " + codigoAgencia;
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Vaga vaga = new Vaga();
            vaga.setVaga_cod(rs.getInt("VAGA_COD"));
            vagas.add(vaga);
        }
        return vagas;
    }
}
