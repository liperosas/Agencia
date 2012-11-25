/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public interface InterfaceCurriculo {
    void inserir(Curriculo curriculo) throws SQLException, ClassNotFoundException;
    void remover(int codCur) throws SQLException, ClassNotFoundException;
    void alterar(Curriculo curriculo) throws SQLException, ClassNotFoundException;
    Curriculo procurar(int codCur) throws SQLException, ClassNotFoundException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    ArrayList<Curriculo> listarCur() throws SQLException, ClassNotFoundException;
}
