/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import classes.Agencia;
import classes.InterfaceVaga;
import classes.Vaga;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lipe
 */
public class RepositorioVaga extends Conexao implements InterfaceVaga {

    Statement conex;

    @Override
    public void inserirVag(Vaga vaga) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "insert into vaga(num_vaga, vaga_local, pre_requisito, tipo_vaga, ag_cod)";
        sql += "values('" + vaga.getNum_vaga() + "','" + vaga.getVaga_local() + "','" + vaga.getPre_requisito() + "','" + vaga.getTipo_vaga() + "','" + vaga.getAgencia().getAg_cod() + "')";
        conex.execute(sql);
        desconectar();
    }

    @Override
    public void removerVag(int cod) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "delete from vaga where vaga_cod =" + cod;
        conex.execute(sql);
        desconectar();
    }

    @Override
    public void alterarVag(Vaga vaga) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "UPDATE vaga SET num_vaga = " + vaga.getNum_vaga() + ",Vaga_Local = '" + vaga.getVaga_local() + "',Pre_Requisito= '" + vaga.getPre_requisito() + "' ,Tipo_Vaga = '" + vaga.getTipo_vaga() + "' , Ag_Cod = " + vaga.getAgencia().getAg_cod() + " WHERE Vaga_Cod = " + vaga.getVaga_cod();
        conex.execute(sql);
        desconectar();
    }

    public Agencia verificar(int ag_cod) throws ClassNotFoundException, SQLException {
        Agencia agencia = new Agencia();
        conex = conectar();
        String sql = "select ag_cod from agencia where ag_cod =" + ag_cod + "";
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            agencia.setAg_cod(rs.getInt("ag_cod"));
        }
        return agencia;
    }

    @Override
    public Vaga procurarVag(int cod) throws SQLException, ClassNotFoundException {
        conex = conectar();
        String sql = "select vaga_cod, num_vaga, vaga_local, pre_requisito, tipo_vaga, ag_cod from vaga where vaga_cod=" + cod;
        ResultSet rs = conex.executeQuery(sql);
        Vaga vaga = new Vaga();
        while (rs.next()) {
            Agencia agcod = new Agencia();
            vaga.setVaga_cod(rs.getInt("vaga_cod"));
            vaga.setNum_vaga(rs.getInt("num_vaga"));
            vaga.setVaga_local(rs.getString("vaga_local"));
            vaga.setPre_requisito(rs.getString("pre_requisito"));
            vaga.setTipo_vaga(rs.getString("tipo_vaga"));
            agcod.setAg_cod(rs.getInt("ag_cod"));
            vaga.setAgencia(agcod);
        }
        desconectar();
        return vaga;
    }

    @Override
    public ArrayList<Vaga> listarVag() throws SQLException, ClassNotFoundException {
        ArrayList<Vaga> vagas = new ArrayList<>();
        conex = conectar();
        String sql = "select vaga_cod, num_vaga, vaga_local, pre_requisito, tipo_vaga, ag_cod from vaga";
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Agencia agcod = new Agencia();
            Vaga vaga = new Vaga();
            vaga.setVaga_cod(rs.getInt("vaga_cod"));
            vaga.setNum_vaga(rs.getInt("num_vaga"));
            vaga.setVaga_local(rs.getString("vaga_local"));
            vaga.setPre_requisito(rs.getString("pre_requisito"));
            vaga.setTipo_vaga(rs.getString("tipo_vaga"));
            agcod.setAg_cod(rs.getInt("ag_cod"));
            vaga.setAgencia(agcod);
            vagas.add(vaga);
        }
        return vagas;
    }

    public ArrayList<Vaga> listarAgenciaVag(String filtro) throws SQLException, ClassNotFoundException {
        ArrayList<Agencia> procurarNome = new ArrayList<Agencia>();
        RepositorioAgencia ra = new RepositorioAgencia();
        procurarNome = ra.procurarAgNome(filtro);
        ArrayList<Vaga> vagas = new ArrayList<Vaga>();

        for (int i = 0; i < procurarNome.size(); i++) {
            String sql = "select vaga_cod, num_vaga, vaga_local, pre_requisito, tipo_vaga, ag_cod from vaga where ag_cod = " + procurarNome.get(i).getAg_cod();
            ResultSet rs = conex.executeQuery(sql);

            while (rs.next()) {
                Agencia agcod = new Agencia();
                Vaga vaga = new Vaga();
                vaga.setVaga_cod(rs.getInt("vaga_cod"));
                vaga.setNum_vaga(rs.getInt("num_vaga"));
                vaga.setVaga_local(rs.getString("vaga_local"));
                vaga.setPre_requisito(rs.getString("pre_requisito"));
                vaga.setTipo_vaga(rs.getString("tipo_vaga"));
                agcod.setAg_cod(rs.getInt("ag_cod"));
                vaga.setAgencia(agcod);
                vagas.add(vaga);
            }
        }
        return vagas;
    }

    public ArrayList<Vaga> listarTipoVag(String filtro) throws SQLException, ClassNotFoundException {
        ArrayList<Vaga> vagas = new ArrayList<>();
        conex = conectar();
        String sql = "select vaga_cod, num_vaga, vaga_local, pre_requisito, tipo_vaga, ag_cod from vaga where vaga_cod=vaga_cod and tipo_vaga like '%" + filtro + "%'";
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Agencia agcod = new Agencia();
            Vaga vaga = new Vaga();
            vaga.setVaga_cod(rs.getInt("vaga_cod"));
            vaga.setNum_vaga(rs.getInt("num_vaga"));
            vaga.setVaga_local(rs.getString("vaga_local"));
            vaga.setPre_requisito(rs.getString("pre_requisito"));
            vaga.setTipo_vaga(rs.getString("tipo_vaga"));
            agcod.setAg_cod(rs.getInt("ag_cod"));
            vaga.setAgencia(agcod);
            vagas.add(vaga);
        }
        return vagas;
    }

    public ArrayList<Vaga> listarPreReqVag(String filtro) throws SQLException, ClassNotFoundException {
        ArrayList<Vaga> vagas = new ArrayList<>();
        conex = conectar();
        String sql = "select vaga_cod, num_vaga, vaga_local, pre_requisito, tipo_vaga, ag_cod from vaga where vaga_cod=vaga_cod and pre_requisito like '%" + filtro + "%'";
        ResultSet rs = conex.executeQuery(sql);
        while (rs.next()) {
            Agencia agcod = new Agencia();
            Vaga vaga = new Vaga();
            vaga.setVaga_cod(rs.getInt("vaga_cod"));
            vaga.setNum_vaga(rs.getInt("num_vaga"));
            vaga.setVaga_local(rs.getString("vaga_local"));
            vaga.setPre_requisito(rs.getString("pre_requisito"));
            vaga.setTipo_vaga(rs.getString("tipo_vaga"));
            agcod.setAg_cod(rs.getInt("ag_cod"));
            vaga.setAgencia(agcod);
            vagas.add(vaga);
        }
        return vagas;
    }
}
