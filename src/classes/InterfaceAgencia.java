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
    ArrayList<Categoria> listarCatAg(int cod)throws SQLException, ClassNotFoundException;
    ArrayList<Agencia> listarAg(Agencia filtro) throws SQLException, ClassNotFoundException;   
}
