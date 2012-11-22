/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Felipe
 */
public class Conexao {
    Statement stm;
    Connection con;
    /*
    public Statement conectar() throws SQLException, ClassNotFoundException{
    //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); - nao pega
    Class c = sun.jdbc.odbc.JdbcOdbcDriver.class;     
    String odbc = "agencia";
    con = DriverManager.getConnection("jdbc:odbc:"+odbc);
    stm = con.createStatement();
    return stm;
    }
    
    public void desconectar() throws SQLException, ClassNotFoundException{
    con.close();
    }
   */ 
    public Statement conectar() throws ClassNotFoundException, SQLException{
        try{
        String driver = "com.mysql.jdbc.Driver";
        String dataBaseName = "agencia";
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String senha = "";
        Class.forName(driver).newInstance();
        con = (Connection) DriverManager.getConnection(url + dataBaseName, usuario, senha);
        stm = con.createStatement();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new SQLException(ex.getMessage());
        }
        return stm;
    }
     public void desconectar() throws SQLException, ClassNotFoundException{
    con.close();
    }
}
