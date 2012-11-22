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
    void removerCur(int cod) throws SQLException, ClassNotFoundException;
    void alterarCur(Curriculo curriculo) throws SQLException, ClassNotFoundException;
    Curriculo procurarCur(int cod) throws SQLException, ClassNotFoundException;
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    ArrayList<Curriculo> listarCur() throws SQLException, ClassNotFoundException;
}
