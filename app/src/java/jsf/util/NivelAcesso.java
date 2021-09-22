/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.util;

/**
 *
 * @author nigel
 */
public class NivelAcesso {
    String descricao;
    int nivel;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public NivelAcesso(int nivel, String desc)
    {
        this.nivel = nivel;
        this.descricao = desc;
    }
}
