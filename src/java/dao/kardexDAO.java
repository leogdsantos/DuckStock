/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.kardex;
import model.marca;
import util.ConexaoBD;

/**
 *
 * @author Giovani
 */
public class kardexDAO {

    public void cadastrar(kardex kard) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para inserir movimentação de itens
        PreparedStatement comando = con.prepareStatement("insert into kardex (CODIGO_USER, DATAMOVIMENTO, TIPOMOVIMENTO_ID, CODIGOPRODUTO_ID, QTDPRODUTO, VLRPRODUTO, VLRMOVIMENTO)"
                + " values (?, ?, ?, ?, ?, ?, ?)");
        
        java.util.Date data1 = new java.util.Date();        
        data1 = kard.getDatamovimento();
        
        java.sql.Date dataSql = new java.sql.Date(data1.getTime());
        
        comando.setInt(1, (int) kard.getCodigo_user());
        comando.setDate(2, (Date) dataSql);
        comando.setInt(3, (int) kard.getTipomovimento_id());
        comando.setDouble(4, kard.getCodigoproduto_id());
        comando.setDouble(5, kard.getQtdproduto());
        comando.setDouble(6, kard.getVlrproduto());
        comando.setDouble(7, kard.getVlrmovimento());

        comando.execute();
        comando.close();
    }

    public void atualizar(kardex kard) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para atualizar movimentação de itens
        PreparedStatement comando = con.prepareStatement("UPDATE KARDEX SET CODIGO_USER = ?, DATAMOVIMENTO = ?, "
                + "TIPOMOVIMENTO_ID = ?, CODIGOPRODUTO_ID = ?, QTDPRODUTO = ?, VLRPRODUTO = ?, VLRMOVIMENTO = ? "
                + "WHERE CODIGO = ?");

        java.util.Date data1 = new java.util.Date();        
        data1 = kard.getDatamovimento();
        
        java.sql.Date dataSql = new java.sql.Date(data1.getTime());
                
        comando.setInt(1, (int) kard.getCodigo_user());
        comando.setDate(2, (Date) dataSql);
        comando.setInt(3, (int) kard.getTipomovimento_id());
        comando.setDouble(4, kard.getCodigoproduto_id());
        comando.setDouble(5, kard.getQtdproduto());
        comando.setDouble(6, kard.getVlrproduto());
        comando.setDouble(7, kard.getVlrmovimento());
        comando.setInt(8, kard.getCodigo());

        comando.execute();
        comando.close();
    }

    public void deletar(kardex kard) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();
        
        //Instrução SQL para deletar movimentação de itens
        PreparedStatement comando = con.prepareStatement("DELETE FROM KARDEX WHERE CODIGO = (?)");

        comando.setInt(1, (int) kard.getCodigo());
        comando.execute();
        comando.close();
    }
    
    //Método listar não implementado: Relatório de Entrada e Saída atende item do CRUD .   
    public List<kardex> consultar() throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para consultar movimentação de itens
        PreparedStatement comando = con.prepareStatement("SELECT CODIGO_USER, DATAMOVIMENTO, TIPOMOVIMENTO_ID, "
                + "CODIGOPRODUTO_ID, QTDPRODUTO, VLRPRODUTO, VLRMOVIMENTO from KARDEX ");
        ResultSet resultado = comando.executeQuery();

        List<kardex> todosItens = new ArrayList<kardex>();

        while (resultado.next()) {

            kardex kard = new kardex();

            kard.setCodigo_user(resultado.getInt("CODIGO_USER"));
            kard.setDatamovimento(resultado.getDate("DATAMOVIMENTO"));
            kard.setTipomovimento_id(resultado.getInt("TIPOMOVIMENTO_ID"));
            kard.setCodigoproduto_id(resultado.getDouble("CODIGOPRODUTO_ID"));
            kard.setQtdproduto((int) resultado.getDouble("QTDPRODUTO"));
            kard.setVlrproduto(resultado.getDouble("VLRPRODUTO"));
            kard.setVlrmovimento(resultado.getDouble("VLRMOVIMENTO"));

            todosItens.add(kard);
        }
        con.close();
        return todosItens;
    }

}
