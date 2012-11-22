/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocios;

import classes.Agencia;
import classes.Categoria;
import classes.Vaga;
import repositorio.RepositorioAgencia;
import repositorio.RepositorioVaga;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lipe
 */
public class RnAgencia {

    RepositorioAgencia r = new RepositorioAgencia();
    RepositorioVaga rv = new RepositorioVaga();
    /**
     *
     * @param agencia
     * @throws Exception
     */
    public void inserirAg(Agencia agencia) throws Exception {


        try {
            if (agencia.getAg_nome().equals("") || (agencia.getAg_nome() == null)) {
                throw new Exception("Informe um nome para a Agência");
            }
            if (agencia.getAg_endereco().equals("") || agencia.getAg_endereco() == null) {
                throw new Exception("Campo endereço não pode estar vazio");
            }
            if (agencia.getAg_fone().equals("")) {
                throw new Exception("Campo telefone encontra-se vazio. \nfavor informar telefone no formato solicitado");
            } else {
                if (agencia.getAg_fone().length() != 13) {
                    throw new Exception("Informe telefone no formato (xx)xxxx-xxxx");
                }
            }
            if (!(agencia.getAg_email().indexOf("@") != -1 && agencia.getAg_email().indexOf(".") != -1)) {
                throw new Exception("Informe email válido");
            }
            if (agencia.getCategorias().isEmpty()) {
                throw new Exception("Cadastre ao menos uma categoria");
            }
            for (int i = 0; i < agencia.getCategorias().size(); i++) {
                int var = 0;

                for (int j = 0; j < agencia.getCategorias().size(); j++) {
                    if (agencia.getCategorias().get(i).getCat_cod() == agencia.getCategorias().get(j).getCat_cod()) {
                        var++;
                    }
                    if (var > 1) {
                        agencia.getCategorias().clear();
                        throw new Exception("Categoria cadastrada previamente");
                    }
                }
            }
            r.inserirAg(agencia);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void removerAg(int cod) throws Exception {
        try {
            String temp = Integer.toString(cod);
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("Codigo Inválido");
                }
            }           
            ArrayList<Vaga> vagas = new ArrayList<>();
            vagas = r.vagasAgencia(cod);
            if (vagas.isEmpty() == false) {
                throw new Exception("Existe uma vaga com este registro, \nPorfavor remova primeiro todas as vagas com este registro para prosseguir");
            }
            

            r.removerAg(cod);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void alterarAg(Agencia agencia) throws Exception {
        try {
            if (agencia.getAg_nome().equals("") || (agencia.getAg_nome() == null)) {
                throw new Exception("Informe nome da Agência");
            }
            if (agencia.getAg_endereco().equals("") || agencia.getAg_endereco() == null) {
                throw new Exception("Informe endereço válido");
            }
            if (agencia.getAg_fone().equals("")) {
                throw new Exception("Campo telefone encontra-se vazio. \nfavor informar telefone no formato solicitado");
            } else {
                if (agencia.getAg_fone().length() != 13) {
                    throw new Exception("Informe telefone no formato (xx)xxxx-xxxx");
                }
            }
            if (!(agencia.getAg_email().indexOf("@") != -1 || agencia.getAg_email().indexOf(".") != -1)) {
                throw new Exception("Informe email válido");
            }
            r.alterarAg(agencia);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Agencia procurarAg(int cod) throws Exception {
        Agencia age = new Agencia();
        try {
            String temp = Integer.toString(cod);
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("Codigo Inválido");
                }
            }
            age = r.procurarAg(cod);
            if (age == null) {
                throw new Exception("Não existe agência com este código");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        return age;
    }

    public ArrayList<Categoria> listarCatAg(int cod) throws Exception {
        ArrayList<Categoria> categ = new ArrayList<>();
        try {
            categ = r.listarCatAg(cod);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
        return categ;
    }

    public ArrayList<Agencia> listar(Agencia filtro) throws Exception {
        ArrayList<Agencia> lista = new ArrayList<>();
        try {
            lista = r.listarAg(filtro);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Agencia> listarNomeAg(String filtro)throws Exception{
        ArrayList<Agencia> lista = new ArrayList<>();
        try {
            lista = r.listarNomeAg(filtro);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
        return lista;
    }

    public void alterarCategoriaAgencia(int codigoAgencia, int codigoCategoria, int novoCodigoCategoria) throws Exception {

        try {
            Categoria cat = new Categoria();
            cat = r.verificarCat(codigoAgencia, novoCodigoCategoria);

            if (cat.getCat_cod() != 0) {
                throw new Exception("Categoria já cadastrada");
            }
            r.alterarCategoriaAgencia(codigoAgencia, codigoCategoria, novoCodigoCategoria);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
    }

    public void cadastrarCategoriaAgencia(int codigoAgencia, int codigoCategoria) throws Exception {
        try {
            Categoria cat = new Categoria();
            cat = r.verificarCat(codigoAgencia, codigoCategoria);

            if (cat.getCat_cod() != 0) {
                throw new Exception("Categoria já cadastrada");
            }
            r.cadastrarCategoriaAgencia(codigoAgencia, codigoCategoria);

        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
    }

    public void removerCategoriaAgencia(int codigoAgencia, int codigoCategoria) throws Exception {
        try {
            r.removerCategoriaAgencia(codigoAgencia, codigoCategoria);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
    }

    public Categoria verificarCat(int codigoAgencia, int codigoCategoria) throws Exception {
        Categoria cat = new Categoria();
        try {
            cat = r.verificarCat(codigoAgencia, codigoCategoria);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
        return cat;
    }
}
