package model;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giovani
 */
public class kardex {

    private int codigo;
    private int codigo_user;
    private Date datamovimento;
    private Date datamovimento2;
    private int tipomovimento_id;
    private double codigoproduto_id;
    private double qtdproduto;
    private double vlrproduto;
    private double vlrmovimento;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo_user() {
        return codigo_user;
    }

    public void setCodigo_user(int codigo_user) {
        this.codigo_user = codigo_user;
    }

    public Date getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(Date datamovimento) {
        this.datamovimento = datamovimento;
    }

    public int getTipomovimento_id() {
        return tipomovimento_id;
    }
    
    public Date getDatamovimento2() {
        return datamovimento2;
    }

    public void setDatamovimento2(Date datamovimento2) {
        this.datamovimento2 = datamovimento2;
    }

    public void setTipomovimento_id(int tipomovimento_id) {
        this.tipomovimento_id = tipomovimento_id;
    }

    public double getCodigoproduto_id() {
        return codigoproduto_id;
    }

    public void setCodigoproduto_id(double codigoproduto_id) {
        this.codigoproduto_id = codigoproduto_id;
    }

    public double getQtdproduto() {
        return qtdproduto;
    }

    public void setQtdproduto(double qtdproduto) {
        this.qtdproduto = qtdproduto;
    }

    public double getVlrproduto() {
        return vlrproduto;
    }

    public void setVlrproduto(double vlrproduto) {
        this.vlrproduto = vlrproduto;
    }

    public double getVlrmovimento() {
        return vlrmovimento;
    }

    public void setVlrmovimento(double vlrmovimento) {
        this.vlrmovimento = vlrmovimento;
    }
/*
    public void setDatamovimento(java.util.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
