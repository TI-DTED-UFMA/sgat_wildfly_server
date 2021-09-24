/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smgt.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nigel
 */
@Entity
@Table(name = "tb_solicitante_equipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitanteEquipe.findAll", query = "SELECT t FROM TbSolicitanteEquipe t")
    , @NamedQuery(name = "TbSolicitanteEquipe.findByCodigo", query = "SELECT t FROM TbSolicitanteEquipe t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitanteEquipe.findByNome", query = "SELECT t FROM TbSolicitanteEquipe t WHERE t.nome = :nome")
    , @NamedQuery(name = "TbSolicitanteEquipe.findByIne", query = "SELECT t FROM TbSolicitanteEquipe t WHERE t.ine = :ine")
    , @NamedQuery(name = "TbSolicitanteEquipe.findByUnidade", query = "SELECT t FROM TbSolicitanteEquipe t WHERE t.unidade = :unidade")
    , @NamedQuery(name = "TbSolicitanteEquipe.findByTipoequipe", query = "SELECT t FROM TbSolicitanteEquipe t WHERE t.tipoequipe = :tipoequipe")
    , @NamedQuery(name = "TbSolicitanteEquipe.findByAtivo", query = "SELECT t FROM TbSolicitanteEquipe t WHERE t.ativo = :ativo")
    , @NamedQuery(name = "TbSolicitanteEquipe.findByDataAtualizacao", query = "SELECT t FROM TbSolicitanteEquipe t WHERE t.dataAtualizacao = :dataAtualizacao")})
public class TbSolicitanteEquipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ine")
    private int ine;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidade")
    private int unidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoequipe")
    private int tipoequipe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ativo")
    private int ativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

    public TbSolicitanteEquipe() {
    }

    public TbSolicitanteEquipe(Integer codigo) {
        this.codigo = codigo;
    }

    public TbSolicitanteEquipe(Integer codigo, String nome, int ine, int unidade, int tipoequipe, int ativo, Date dataAtualizacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.ine = ine;
        this.unidade = unidade;
        this.tipoequipe = tipoequipe;
        this.ativo = ativo;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIne() {
        return ine;
    }

    public void setIne(int ine) {
        this.ine = ine;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public int getTipoequipe() {
        return tipoequipe;
    }

    public void setTipoequipe(int tipoequipe) {
        this.tipoequipe = tipoequipe;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSolicitanteEquipe)) {
            return false;
        }
        TbSolicitanteEquipe other = (TbSolicitanteEquipe) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitanteEquipe[ codigo=" + codigo + " ]";
    }
    
}
