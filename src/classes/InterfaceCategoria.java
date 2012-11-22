/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;

/**
 *
 * @author Lipe
 */
public interface InterfaceCategoria {
    
    void inserirCat(Categoria categoria) throws SQLException, ClassNotFoundException;
    void removerCat(int cod) throws SQLException, ClassNotFoundException;
    void alterarCat(Categoria categoria) throws SQLException, ClassNotFoundException;
    Categoria procurarCat(int cod) throws SQLException, ClassNotFoundException;
    void testemelo(Categoria nome) throws Exception;
}
