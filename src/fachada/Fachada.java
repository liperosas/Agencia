/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import classes.Agencia;
import classes.Categoria;
import classes.Curriculo;
import classes.Vaga;
import regraNegocios.RnAgencia;
import regraNegocios.RnCategoria;
import regraNegocios.RnCurriculo;
import regraNegocios.RnVaga;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class Fachada {

    RnCurriculo rnc = new RnCurriculo();
    RnAgencia rna = new RnAgencia();
    RnCategoria rncat = new RnCategoria();
    RnVaga rnv = new RnVaga();

    public Fachada() {
    }

    public void inserir(Curriculo curriculo) throws Exception {
        rnc.inserir(curriculo);
    }

    public void remover(int codCur) throws Exception {
        rnc.remover(codCur);
    }

    public void alterar(Curriculo curriculo) throws Exception {
        rnc.alterar(curriculo);
    }

    public Curriculo procurar(int codCur) throws Exception {
        Curriculo cur = new Curriculo();
        cur = rnc.procurar(codCur);

        return cur;
    }

    public ArrayList<Curriculo> listar() throws Exception {
        ArrayList<Curriculo> lista = new ArrayList<Curriculo>();
        lista = rnc.listarCur();
        return lista;
    }

    public ArrayList<Curriculo> listarNomeCur(String filtro) throws Exception {
        ArrayList<Curriculo> lista = new ArrayList<Curriculo>();
        lista = rnc.listarNomeCur(filtro);
        return lista;
    }

    public ArrayList<Curriculo> listarSobreNomeCur(String filtro) throws Exception {
        ArrayList<Curriculo> lista = new ArrayList<Curriculo>();
        lista = rnc.listarSobreNomeCur(filtro);
        return lista;
    }

    public void inserir(Agencia agencia) throws Exception {
        rna.inserirAg(agencia);
    }

    public void removerAg(int cod) throws Exception {
        rna.removerAg(cod);
    }

    public void alterar(Agencia agencia) throws Exception {
        rna.alterarAg(agencia);
    }

    public Agencia procurarAg(int cod) throws Exception {
        Agencia age = new Agencia();
        age = rna.procurarAg(cod);

        return age;
    }

    public ArrayList<Agencia> procurarAgNome(String filtro) throws Exception {
        ArrayList<Agencia> lista = new ArrayList<Agencia>();
        lista = rna.procurarAgNome(filtro);
        return lista;
    }

    public ArrayList<Categoria> listarCatAg(int cod) throws Exception {
        ArrayList<Categoria> categ = new ArrayList<Categoria>();
        categ = rna.listarCatAg(cod);
        return categ;
    }

    public ArrayList<Agencia> listar(Agencia filtro) throws Exception {
        ArrayList<Agencia> lista = new ArrayList<Agencia>();
        lista = rna.listar(filtro);
        return lista;
    }

    public ArrayList<Agencia> listarNomeAg(String filtro) throws Exception {
        ArrayList<Agencia> lista = new ArrayList<Agencia>();
        lista = rna.listarNomeAg(filtro);
        return lista;
    }
    
     public ArrayList<Agencia> validarAg(String filtro) throws Exception {
        ArrayList<Agencia> lista = new ArrayList<Agencia>();
        lista = rna.validarAg(filtro);
        return lista;
    }

    public void inserir(Categoria categoria) throws Exception {
        rncat.inserirCat(categoria);
    }

    public void removerCat(int cod) throws Exception {
        rncat.removerCat(cod);
    }

    public void alterar(Categoria categoria) throws Exception {
        rncat.alterarCat(categoria);
    }

    public Categoria procurarCat(int cod) throws Exception {
        Categoria cat = new Categoria();
        cat = rncat.procurarCat(cod);
        return cat;
    }

    public ArrayList<Categoria> listarCat() throws Exception {
        ArrayList<Categoria> lista = new ArrayList<>();
        lista = rncat.listarCat();
        return lista;
    }

    public void inserir(Vaga vaga) throws Exception {
        rnv.inserirVag(vaga);
    }

    public void removerVag(int cod) throws Exception {
        rnv.removerVag(cod);
    }

    public void alterar(Vaga vaga) throws Exception {
        rnv.alterarVag(vaga);
    }

    public Vaga procurarVag(int cod) throws Exception {
        Vaga vag = new Vaga();
        vag = rnv.procurarVag(cod);
        return vag;
    }

    public ArrayList<Vaga> listarVag() throws Exception {
        ArrayList<Vaga> lista = new ArrayList<>();
        lista = rnv.listarVag();
        return lista;
    }

    public ArrayList<Vaga> listarAgenciaVag(String filtro) throws Exception {
        ArrayList<Vaga> lista = new ArrayList<Vaga>();
        lista = rnv.listarAgenciaVag(filtro);
        return lista;
    }

    public ArrayList<Vaga> listarTipoVag(String filtro) throws Exception {
        ArrayList<Vaga> lista = new ArrayList<Vaga>();
        lista = rnv.listarTipoVag(filtro);
        return lista;
    }

    public ArrayList<Vaga> listarPreReqVag(String filtro) throws Exception {
        ArrayList<Vaga> lista = new ArrayList<Vaga>();
        lista = rnv.listarPreReqVag(filtro);
        return lista;
    }

    public int verificar(int ag_cod) throws Exception {
        rnv.verificar(ag_cod);
        return ag_cod;
    }

    public void alterarCategoriaAgencia(int codigoAgencia, int codigoCategoria, int novoCodigoCategoria) throws Exception {
        rna.alterarCategoriaAgencia(codigoAgencia, codigoCategoria, novoCodigoCategoria);
    }

    public void cadastrarCategoriaAgencia(int codigoAgencia, int codigoCategoria) throws Exception {
        rna.cadastrarCategoriaAgencia(codigoAgencia, codigoCategoria);
    }

    public void removerCategoriaAgencia(int codigoAgencia, int codigoCategoria) throws Exception {
        rna.removerCategoriaAgencia(codigoAgencia, codigoCategoria);
    }

    public void validarNumVaga(String num) throws Exception {
        rnv.validarNumVaga(num);
    }

    public ArrayList<Agencia> listarAgenciaCat(int codigoCat) throws Exception {
        ArrayList<Agencia> lista = new ArrayList<Agencia>();
        lista = rna.listarAgenciaCat(codigoCat);
        return lista;
    }
}
