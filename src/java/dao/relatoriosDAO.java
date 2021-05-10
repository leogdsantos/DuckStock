/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.itensestoque;
import model.marca;
import model.kardex;
import model.relatorios;
import util.ConexaoBD;

/**
 *
 * @author Giovani
 */
public class relatoriosDAO {

    public List<relatorios> relatEntradaSaida(relatorios kard) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para consulta relatório entrada e saída
        PreparedStatement comando = con.prepareStatement("select datamovimento, descricao, codigoproduto_id, descricaodetalhada, qtdproduto from kardex\n"
                + "	inner join itensestoque on codigoproduto_id = id_ie\n"
                + "	inner join movimento on tipomovimento_id = id_mov\n"
                + "	where datamovimento between ? and ? "
                + "	order by datamovimento ");

        //Instrução para tratamento do modelo de dados tipo DATA JAVA
        java.util.Date dataini = new java.util.Date();
        java.util.Date datafim = new java.util.Date();

        dataini = kard.getDatamovimento();
        datafim = kard.getDatamovimento2();

        //Instrução para tratamento do modelo de dados tipo DATA SQL
        java.sql.Date dataSqlIni = new java.sql.Date(dataini.getTime());
        java.sql.Date dataSqlFim = new java.sql.Date(datafim.getTime());

        comando.setDate(1, (java.sql.Date) (Date) dataSqlIni);
        comando.setDate(2, (java.sql.Date) (Date) dataSqlFim);

        ResultSet resultado = comando.executeQuery();
        List<relatorios> todosItens = new ArrayList<relatorios>();
        
        //Estrutura de repetição para preenchimento da ArrayList
        while (resultado.next()) {

            relatorios kardList = new relatorios();

            kardList.setDatamovimento(resultado.getDate("datamovimento"));
            kardList.setDescricaomov(resultado.getString("descricao"));
            kardList.setCodigoproduto_id(resultado.getDouble("codigoproduto_id"));
            kardList.setDescricaodetalhada(resultado.getString("descricaodetalhada"));
            kardList.setQtdproduto(resultado.getInt("qtdproduto"));

            todosItens.add(kardList);
        }
        con.close();
        return todosItens;
    }

    public List<relatorios> relatvlrestoque(relatorios kard) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();

        //Instrução SQL para consulta relatório valor estoque
        PreparedStatement comando = con.prepareStatement("select id_ge, descricao, sum (qtdproduto) as qtdprod, sum (vlrmovimento)as vlr from kardex	\n"
                + "	inner join itensestoque on codigoproduto_id = id_ie\n"
                + "	inner join grupoestoque on codigogp_id = id_ge\n"
                + "	group by id_ge, descricao\n"
                + "	order by id_ge ");

        ResultSet resultado = comando.executeQuery();
        List<relatorios> todosItens = new ArrayList<relatorios>();

        //Estrutura de repetição para preenchimento da ArrayList
        while (resultado.next()) {

            relatorios kardList = new relatorios();

            kardList.setId_ge(resultado.getInt("id_ge"));
            kardList.setDescricaogp(resultado.getString("descricao"));
            kardList.setQtdproduto(resultado.getDouble("qtdprod"));
            kardList.setVlrmovimento(resultado.getDouble("vlr"));

            todosItens.add(kardList);
        }
        con.close();
        return todosItens;
    }

    public List<relatorios> relatBaixoGiro(relatorios kard) throws ClassNotFoundException, SQLException {

        //Conexão com banco de dados
        ConexaoBD conexao = new ConexaoBD();
        Connection con = conexao.getConexao();
        
        //Instrução SQL para consulta relatório baixo giro
        PreparedStatement comando = con.prepareStatement("SELECT CODIGOPRODUTO_ID, DESCRICAODETALHADA, SUM (QTDPRODUTO) AS QTDVENDIDA FROM KARDEX\n" +
        "	INNER JOIN ITENSESTOQUE on CODIGOPRODUTO_ID = ID_IE\n" +
        "	WHERE TIPOMOVIMENTO_ID = 11 and KARDEX.datamovimento BETWEEN ? and ? \n" +
        "	group by CODIGOPRODUTO_ID, DESCRICAODETALHADA\n" +
        "	ORDER BY QTDVENDIDA DESC");

        java.util.Date dataini = new java.util.Date();
        java.util.Date datafim = new java.util.Date();

        dataini = kard.getDatamovimento();
        datafim = kard.getDatamovimento2();

        java.sql.Date dataSqlIni = new java.sql.Date(dataini.getTime());
        java.sql.Date dataSqlFim = new java.sql.Date(datafim.getTime());

        comando.setDate(1, (java.sql.Date) (Date) dataSqlIni);
        comando.setDate(2, (java.sql.Date) (Date) dataSqlFim);

        ResultSet resultado = comando.executeQuery();
        List<relatorios> todosItens = new ArrayList<relatorios>();

        //Estrutura de repetição para preenchimento da ArrayList
        while (resultado.next()) {

            relatorios kardList = new relatorios();
            
            kardList.setCodigoproduto_id(resultado.getDouble("codigoproduto_id"));
            kardList.setDescricaodetalhada(resultado.getString("descricaodetalhada"));
            kardList.setQtdproduto(resultado.getInt("qtdvendida"));

            todosItens.add(kardList);
        }
        con.close();
        return todosItens;
    }

}
