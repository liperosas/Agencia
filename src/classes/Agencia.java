/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Lipe
 */
public class Agencia {
    private int ag_cod;
    private String ag_nome;    
    private String ag_endereco;
    private String ag_fone;
    private String ag_email;    
    private String ag_outras_info;
    private ArrayList<Categoria> categorias;

    /**
     * @return the ag_cod
     */
    public int getAg_cod() {
        return ag_cod;
    }

    /**
     * @param ag_cod the ag_cod to set
     */
    public void setAg_cod(int ag_cod) {
        this.ag_cod = ag_cod;
    }

    /**
     * @return the ag_nome
     */
    public String getAg_nome() {
        return ag_nome;
    }

    /**
     * @param ag_nome the ag_nome to set
     */
    public void setAg_nome(String ag_nome) {
        this.ag_nome = ag_nome;
    }

    /**
     * @return the ag_endereco
     */
    public String getAg_endereco() {
        return ag_endereco;
    }

    /**
     * @param ag_endereco the ag_endereco to set
     */
    public void setAg_endereco(String ag_endereco) {
        this.ag_endereco = ag_endereco;
    }

    /**
     * @return the ag_fone
     */
    public String getAg_fone() {
        return ag_fone;
    }

    /**
     * @param ag_fone the ag_fone to set
     */
    public void setAg_fone(String ag_fone) {
        this.ag_fone = ag_fone;
    }

    /**
     * @return the ag_email
     */
    public String getAg_email() {
        return ag_email;
    }

    /**
     * @param ag_email the ag_email to set
     */
    public void setAg_email(String ag_email) {
        this.ag_email = ag_email;
    }

    /**
     * @return the ag_outras_info
     */
    public String getAg_outras_info() {
        return ag_outras_info;
    }

    /**
     * @param ag_outras_info the ag_outras_info to set
     */
    public void setAg_outras_info(String ag_outras_info) {
        this.ag_outras_info = ag_outras_info;
    }

    /**
     * @return the categorias
     */
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

}
