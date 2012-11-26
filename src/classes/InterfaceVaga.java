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

    Agencia verificar(int ag_cod) throws ClassNotFoundException, SQLException;

    Vaga procurarVag(int cod) throws SQLException, ClassNotFoundException;

    ArrayList<Vaga> listarVag() throws SQLException, ClassNotFoundException;

    ArrayList<Vaga> listarAgenciaVag(String filtro) throws SQLException, ClassNotFoundException;

    ArrayList<Vaga> listarTipoVag(String filtro) throws SQLException, ClassNotFoundException;

    ArrayList<Vaga> listarPreReqVag(String filtro) throws SQLException, ClassNotFoundException;
}
