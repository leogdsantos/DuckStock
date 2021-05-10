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
public class movimento {
    private int id_mov;
    private String descricao;

    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
