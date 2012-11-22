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
public interface InterfaceVaga {
    void inserirVag(Vaga vaga) throws SQLException, ClassNotFoundException;
    void removerVag(int cod) throws SQLException, ClassNotFoundException;
    void alterarVag(Vaga vaga) throws SQLException, ClassNotFoundException;
    Vaga procurarVag(int cod) throws SQLException, ClassNotFoundException;
    ArrayList<Vaga> listarVag() throws SQLException, ClassNotFoundException;
}
