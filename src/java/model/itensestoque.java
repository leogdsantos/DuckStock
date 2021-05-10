package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Giovani
 */
public class itensestoque {

    private double id_ie;
    private double id_ie_consulta;
    private int codigogp_id;
    private int marca_id;
    private String descricaocurta;
    private String descricaodetalhada;

    public double getId_ie() {
        return id_ie;
    }

    public void setId_ie(double id_ie) {
        this.id_ie = id_ie;
    }

    public double getId_ie_consulta() {
        return id_ie_consulta;
    }

    public void setId_ie_consulta(double id_ie_consulta) {
        this.id_ie_consulta = id_ie_consulta;
    }

    public int getCodigogp_id() {
        return codigogp_id;
    }

    public void setCodigogp_id(int codigogp_id) {
        this.codigogp_id = codigogp_id;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    public String getDescricaocurta() {
        return descricaocurta;
    }

    public void setDescricaocurta(String descricaocurta) {
        this.descricaocurta = descricaocurta;
    }

    public String getDescricaodetalhada() {
        return descricaodetalhada;
    }

    public void setDescricaodetalhada(String descricaodetalhada) {
        this.descricaodetalhada = descricaodetalhada;
    }
}
