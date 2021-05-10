/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.itensestoque;
import model.marca;
import util.ConexaoBD;

/**
 *
 * @author Leonardo Gonçalves
 */
public class itensEstoqueDAO {

    public void cadastrar(itensestoque itens) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para inserir de itens
        PreparedStatement comando = con.prepareStatement("insert into itensEstoque(id_ie, codigogp_id, marca_id, descricaocurta, descricaodetalhada) values (?, ?, ?, ?, ? )");

        comando.setDouble(1, itens.getId_ie());
        comando.setInt(2, (int) itens.getCodigogp_id());
        comando.setInt(3, (int) itens.getMarca_id());
        comando.setString(4, itens.getDescricaocurta());
        comando.setString(5, itens.getDescricaodetalhada());

        comando.execute();
        comando.close();
    }

    public void deletar(itensestoque itens) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para deletar itens
        PreparedStatement comando = con.prepareStatement("DELETE FROM itensEstoque WHERE id_ie = (?)");

        comando.setDouble(1, itens.getId_ie());

        comando.execute();
        comando.close();
    }

    public void atualizar(itensestoque itens) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para atualizar itens
        PreparedStatement comando = con.prepareStatement("UPDATE itensEstoque SET id_ie = ?, codigogp_id = ?, marca_id = ?, descricaocurta = ?, descricaodetalhada = ? where id_ie = ?");

        comando.setDouble(1, itens.getId_ie());
        comando.setInt(2, (int) itens.getCodigogp_id());
        comando.setInt(3, (int) itens.getMarca_id());
        comando.setString(4, itens.getDescricaocurta());
        comando.setString(5, itens.getDescricaodetalhada());

        comando.setDouble(6, itens.getId_ie_consulta());

        comando.execute();
        comando.close();
    }

    //não implementado
    public List<marca> listdropdownmarca() throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        PreparedStatement comando = con.prepareStatement("select id_marca, descricao from marca order by descricao");
        ResultSet resultado = comando.executeQuery();

        List<marca> todosItens = new ArrayList<marca>();

        if (resultado.next()) {
            marca marc = new marca();

            marc.setId_marca(resultado.getInt("id_marca"));
            marc.setDescricao(resultado.getString("descricao"));

            marca itens = new marca();

            todosItens.add(marc);
        }
        con.close();
        return todosItens;
    }

    public List<itensestoque> consultarItens() throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para consulta de itens
        PreparedStatement comando = con.prepareStatement("select id_ie,codigogp_id, marca_id, descricaocurta, descricaodetalhada from itensEstoque ");
        ResultSet resultado = comando.executeQuery();

        List<itensestoque> todosItens = new ArrayList<itensestoque>();

        while (resultado.next()) {

            itensestoque itens = new itensestoque();

            itens.setId_ie(resultado.getDouble("id_ie"));
            itens.setCodigogp_id(resultado.getInt("codigogp_id"));
            itens.setMarca_id(resultado.getInt("marca_id"));
            itens.setDescricaocurta(resultado.getString("descricaocurta"));
            itens.setDescricaodetalhada(resultado.getString("descricaodetalhada"));

            todosItens.add(itens);
        }
        con.close();
        return todosItens;
    }

    //Não implementado
    public itensestoque consultarItensById(itensestoque itens) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para consulta de itens
        PreparedStatement comando = con.prepareStatement("select id_ie,codigogp_id, marca_id, descricaocurta, descricaodetalhada from itensEstoque Where id = ?");
        comando.setInt(1, (int) itens.getId_ie());

        ResultSet resultado = comando.executeQuery();

        itensestoque cons = new itensestoque();

        if (resultado.next()) {

            cons.setId_ie(resultado.getInt("id_ie"));
            cons.setCodigogp_id(resultado.getInt("codigogp_id"));
            cons.setMarca_id(resultado.getInt("marca_id"));
            cons.setDescricaocurta(resultado.getString("descricaocurta"));
            cons.setDescricaodetalhada(resultado.getString("descricaodetalhada"));

        }
        con.close();
        return cons;

    }

}
