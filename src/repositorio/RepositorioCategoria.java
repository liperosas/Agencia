/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import classes.Agencia;
import classes.Categoria;
import classes.InterfaceCategoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lipe
 */
public class RepositorioCategoria extends Conexao implements InterfaceCategoria {

    Statement conex;
    
    /**
     *
     * @param nome
     * @throws Exception
     */
    
    public void testemelo(Categoria nome) throws Exception{
        
    }
     

    @Override
    public void inserirCat(Categoria categoria) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "insert into ag_categoria_existentes(tipo_cat)";
        sql += " values('" + categoria.getTipo() + "')";
        conex.execute(sql);
        desconectar();
    }

    @Override
    public void removerCat(int cod) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "delete from ag_categoria_existentes where cat_ag_cod =" + cod;
        conex.execute(sql);
        desconectar();
    }

    @Override
    public void alterarCat(Categoria categoria) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "update ag_categoria_existentes set tipo_cat =" + categoria.getTipo();
        conex.execute(sql);
        desconectar();
    }

    @Override
    public Categoria procurarCat(int cod) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "select Cat_Ag_Cod, tipo_cat from ag_categoria_existentes where cat_ag_cod=" + cod;
        ResultSet rs = conex.executeQuery(sql);
        Categoria categoria = new Categoria();
        while (rs.next()) {
            categoria.setCat_cod(rs.getInt("Cat_Ag_Cod"));
            categoria.setTipo(rs.getString("tipo_cat"));
        }
        desconectar();
        return categoria;
    }

    /**
     *
     * @param cod
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Categoria> listarCat() throws SQLException, ClassNotFoundException {
        ArrayList<Categoria> categorias = new ArrayList<>();
        conex = conectar();
        String sql = "select Cat_Ag_Cod, tipo_cat from ag_categoria_existentes";
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setCat_cod(rs.getInt("Cat_Ag_Cod"));
            categoria.setTipo(rs.getString("tipo_cat"));
            categorias.add(categoria);
        }
        return categorias;

    }

    public ArrayList<Agencia> listarAgencia(int codigoCat) throws SQLException, ClassNotFoundException {
        ArrayList<Agencia> agencias = new ArrayList<>();
        conex = conectar();
        String sql = "select Ag_Cod from categorias_da_agencia where Cat_Ag_Cod =" + codigoCat;
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Agencia agencia = new Agencia();
            agencia.setAg_cod(rs.getInt("Ag_Cod"));
            agencias.add(agencia);
        }
        return agencias;
    }
    
}
