/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocios;

import classes.Agencia;
import classes.Vaga;
import repositorio.RepositorioVaga;
import java.sql.SQLException;
import java.util.ArrayList;
import repositorio.RepositorioAgencia;

/**
 *
 * @author Lipe
 */
public class RnVaga {

    RepositorioVaga r = new RepositorioVaga();
    RepositorioAgencia ra = new RepositorioAgencia();

    public int verificar(int ag_cod) throws Exception {
        try {
            r.verificar(ag_cod);

            if (ag_cod == 0) {
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        return 0;
    }

    public void inserirVag(Vaga vaga) throws Exception {
        try {
            /*
             if(vaga.getAgencia().getAg_nome().isEmpty()){
             throw new Exception ("Favor selecionar uma agência");
             }
             */
            if (vaga.getVaga_local().equals("") || (vaga.getVaga_local() == null)) {
                throw new Exception("Campo local encontra-se vazio.\n Favor informar local");
            }
            if (vaga.getTipo_vaga().equals("") || vaga.getTipo_vaga() == null) {
                throw new Exception("Campo tipo encontra-se vazio.\nFavor informar tipo");
            }

            Agencia agencia = new Agencia();
            agencia = r.verificar(vaga.getAgencia().getAg_cod());
            if (agencia.getAg_cod() == 0) {
                throw new Exception("Agencia Inválida.\nNão existe agência com este código ");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        r.inserirVag(vaga);
    }

    public void removerVag(int cod) throws Exception {
        try {
            String temp = Integer.toString(cod);
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("Codigo Inválido");
                }
            }
            r.removerVag(cod);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void alterarVag(Vaga vaga) throws Exception {
        try {
            String temp = Integer.toString(vaga.getNum_vaga());
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("informe número de vagas correto");
                }
            }

            if (vaga.getVaga_local().equals("") || (vaga.getVaga_local() == null)) {
                throw new Exception("Informe local");
            }
            if (vaga.getTipo_vaga().equals("") || vaga.getTipo_vaga() == null) {
                throw new Exception("Informe tipo válido");
            }

            r.alterarVag(vaga);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Vaga procurarVag(int cod) throws Exception {
        Vaga vag = new Vaga();
        try {
            String temp = Integer.toString(cod);
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("Codigo Inválido");
                }
            }
            vag = r.procurarVag(cod);
            if (vag == null) {
                throw new Exception("Não existe vaga com este código");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        return vag;
    }

    public ArrayList<Vaga> listarVag() throws Exception {
        ArrayList<Vaga> lista = new ArrayList<>();
        try {
            lista = r.listarVag();
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
        return lista;
    }

    public void validarNumVaga(String num) throws Exception {

        if (num.equals("")) {
            throw new Exception("Campo número de vagas encontra-se vazio. \nFavor informar valor numérico");
        }
        for (int i = 0; i < num.length(); i++) {
            char numero = num.charAt(i);
            if (Character.isDigit(numero) == false) {
                throw new Exception("Informe apenas valores numéricos no campo Número de Vagas");
            }
        }
    }
}