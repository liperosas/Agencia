/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocios;

import classes.Agencia;
import classes.Categoria;
import repositorio.RepositorioCategoria;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Lipe
 */
public class RnCategoria {

    RepositorioCategoria r = new RepositorioCategoria();

    public void inserirCat(Categoria categoria) throws Exception {
        try {
            if (categoria.getTipo().trim().equals("") || (categoria.getTipo() == null)) {
                throw new Exception("Informe nome para categoria");
            }
            r.inserirCat(categoria);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void removerCat(int cod) throws Exception {
        try {
            String temp = Integer.toString(cod);           
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("Codigo Inválido");
                }
            }
            ArrayList<Agencia> agencias = new ArrayList<>();
            agencias = r.listarAgencia(cod);
            if (agencias.isEmpty() == false) {
                throw new Exception("Existe uma Agencia com este registro, \nPorfavor remova primeiro todas as Agencias com este registro para prosseguir");
            }

            r.removerCat(cod);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void alterarCat(Categoria categoria) throws Exception {
        try {
            if (categoria.getTipo().equals("") || (categoria.getTipo() == null)) {
                throw new Exception("Informe categoria");
            }
            r.alterarCat(categoria);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Categoria procurarCat(int cod) throws Exception {
        Categoria cat = new Categoria();
        try {
            String temp = Integer.toString(cod);
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("Código Inválido");
                }
            }
            cat = r.procurarCat(cod);
            if (cat == null) {
                throw new Exception("Não existe categoria com este código");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        return cat;
    }

    public ArrayList<Categoria> listarCat() throws Exception {
        ArrayList<Categoria> lista = new ArrayList<>();
        try {
            lista = r.listarCat();
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
        return lista;
    }
}
