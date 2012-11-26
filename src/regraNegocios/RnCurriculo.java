/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocios;

import classes.Curriculo;
import repositorio.RepositorioCurriculo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class RnCurriculo {

    RepositorioCurriculo r = new RepositorioCurriculo();

    /**
     *
     * @param curriculo
     * @throws Exception
     */
    public void inserir(Curriculo curriculo) throws Exception {
        try {
            if (curriculo.getPrimeiroNome().equals("") || (curriculo.getPrimeiroNome() == null)) {
                throw new Exception("Informe primeiro nome");
            }
            if (curriculo.getSobrenome().equals("") || (curriculo.getSobrenome() == null)) {
                throw new Exception("Informe sobrenome");
            }
            if (!"F".equals(curriculo.getSexo()) && !"Feminino".equals(curriculo.getSexo()) && !"M".equals(curriculo.getSexo()) && !"Masculino".equals(curriculo.getSexo())) {
                throw new Exception("Informe sexo válido(Feminino(F)ou Masculino(M)).");
            }
            if (curriculo.getEndereco().equals("") || curriculo.getEndereco() == null) {
                throw new Exception("Informe endereço válido");
            }
            if (curriculo.getContatoFone().equals("")) {
                throw new Exception("Campo telefone encontra-se vazio. \nfavor informar telefone no formato solicitado");
            } else {
                if (curriculo.getContatoFone().length() != 13) {
                    throw new Exception("Informe telefone no formato (xx)xxxx-xxxx");
                }
            }
            if (!(curriculo.getContatoEmail().indexOf("@") != -1 && curriculo.getContatoEmail().indexOf(".") != -1)) {
                throw new Exception("Informe email válido");
            }
            r.inserir(curriculo);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void remover(int codCur) throws Exception {
        try {
            String temp = Integer.toString(codCur);
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("Codigo Inválido");
                }
            }
            r.remover(codCur);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void alterar(Curriculo curriculo) throws Exception {
        try {
            if (curriculo.getPrimeiroNome().equals("") || (curriculo.getPrimeiroNome() == null)) {
                throw new Exception("Informe primeiro nome");
            }
            if (!"F".equals(curriculo.getSexo()) && !"Feminino".equals(curriculo.getSexo()) && !"M".equals(curriculo.getSexo()) && !"Masculino".equals(curriculo.getSexo())) {
                throw new Exception("Informe sexo válido");
            }
            if (curriculo.getEndereco().equals("") || curriculo.getEndereco() == null) {
                throw new Exception("Informe endereço válido");
            }
            if (curriculo.getContatoFone().length() != 13) {
                throw new Exception("Informe telefone válido");
            }
            if (curriculo.getContatoEmail().equals("") || curriculo.getContatoEmail() == null) {
                throw new Exception("Informe email válido");
            }
            r.alterar(curriculo);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Curriculo procurar(int codCur) throws Exception {
        Curriculo cur = new Curriculo();
        try {
            String temp = Integer.toString(codCur);
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);
                if (Character.isDigit(num) == false) {
                    throw new Exception("Codigo Inválido");
                }
            }
            cur = r.procurar(codCur);
            if (cur == null) {
                throw new Exception("Não existe curriculo com este código");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
        return cur;
    }
    
    public ArrayList<Curriculo> listarCur() throws Exception{
        ArrayList<Curriculo> lista = new ArrayList<>();
        try{
        lista = r.listarCur();
        }catch(  SQLException | ClassNotFoundException e){
        throw new Exception(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Curriculo> listarNomeCur(String filtro)throws Exception{
        ArrayList<Curriculo> lista = new ArrayList<>();
        try {
            lista = r.listarNomeCur(filtro);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Curriculo> listarSobreNomeCur(String filtro)throws Exception{
        ArrayList<Curriculo> lista = new ArrayList<>();
        try {
            lista = r.listarSobreNomeCur(filtro);
        } catch (SQLException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
        return lista;
    }
}
