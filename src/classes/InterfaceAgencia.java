/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lipe
 */
public interface InterfaceAgencia {

    void inserirAg(Agencia agencia) throws SQLException, ClassNotFoundException;

    void removerAg(int cod) throws SQLException, ClassNotFoundException;

    void alterarAg(Agencia Agencia) throws SQLException, ClassNotFoundException;

    Agencia procurarAg(int cod) throws SQLException, ClassNotFoundException;

    ArrayList<Agencia> procurarAgNome(String filtro) throws SQLException, ClassNotFoundException;

    ArrayList<Categoria> listarCatAg(int cod) throws SQLException, ClassNotFoundException;

    ArrayList<Agencia> listarAg(Agencia filtro) throws SQLException, ClassNotFoundException;

    ArrayList<Agencia> listarNomeAg(String filtro) throws SQLException, ClassNotFoundException;

    void alterarCategoriaAgencia(int codigoAgencia, int codigoCategoria, int novoCodigoCategoria) throws ClassNotFoundException, SQLException;

    void cadastrarCategoriaAgencia(int codigoAgencia, int codigoCategoria) throws ClassNotFoundException, SQLException;

    void removerCategoriaAgencia(int codigoAgencia, int codigoCategoria) throws ClassNotFoundException, SQLException;

    Categoria verificarCat(int codigoAgencia, int codigoCategoria) throws ClassNotFoundException, SQLException;

    ArrayList<Vaga> vagasAgencia(int codigoAgencia) throws ClassNotFoundException, SQLException;

    ArrayList<Agencia> listarAgenciaCat(int codigoCat) throws SQLException, ClassNotFoundException;

    ArrayList<Agencia> validarAg(String filtro) throws SQLException, ClassNotFoundException;
}
