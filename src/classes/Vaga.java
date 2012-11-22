/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Lipe
 */
public class Vaga {
    private int vaga_cod;
    private int num_vaga;
    private String vaga_local;
    private String pre_requisito;
    private String tipo_vaga;
    private Agencia agencia;

    /**
     * @return the vaga_cod
     */
    public int getVaga_cod() {
        return vaga_cod;
    }

    /**
     * @param vaga_cod the vaga_cod to set
     */
    public void setVaga_cod(int vaga_cod) {
        this.vaga_cod = vaga_cod;
    }

    /**
     * @return the vaga_local
     */
    public String getVaga_local() {
        return vaga_local;
    }

    /**
     * @param vaga_local the vaga_local to set
     */
    public void setVaga_local(String vaga_local) {
        this.vaga_local = vaga_local;
    }

    /**
     * @return the pre_requisito
     */
    public String getPre_requisito() {
        return pre_requisito;
    }

    /**
     * @param pre_requisito the pre_requisito to set
     */
    public void setPre_requisito(String pre_requisito) {
        this.pre_requisito = pre_requisito;
    }

    /**
     * @return the tipo_vaga
     */
    public String getTipo_vaga() {
        return tipo_vaga;
    }

    /**
     * @param tipo_vaga the tipo_vaga to set
     */
    public void setTipo_vaga(String tipo_vaga) {
        this.tipo_vaga = tipo_vaga;
    }

    /**
     * @return the agencia
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the num_vaga
     */
    public int getNum_vaga() {
        return num_vaga;
    }

    /**
     * @param num_vaga the num_vaga to set
     */
    public void setNum_vaga(int num_vaga) {
        this.num_vaga = num_vaga;
    }
}
