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
@Table(name = "tb_solicitante_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitantePerfil.findAll", query = "SELECT t FROM TbSolicitantePerfil t")
    , @NamedQuery(name = "TbSolicitantePerfil.findByCodigo", query = "SELECT t FROM TbSolicitantePerfil t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitantePerfil.findByPessoa", query = "SELECT t FROM TbSolicitantePerfil t WHERE t.pessoa = :pessoa")
    , @NamedQuery(name = "TbSolicitantePerfil.findByCbo", query = "SELECT t FROM TbSolicitantePerfil t WHERE t.cbo = :cbo")
    , @NamedQuery(name = "TbSolicitantePerfil.findByRegistroprof", query = "SELECT t FROM TbSolicitantePerfil t WHERE t.registroprof = :registroprof")
    , @NamedQuery(name = "TbSolicitantePerfil.findByTipoProfissional", query = "SELECT t FROM TbSolicitantePerfil t WHERE t.tipoProfissional = :tipoProfissional")
    , @NamedQuery(name = "TbSolicitantePerfil.findByAtuacao", query = "SELECT t FROM TbSolicitantePerfil t WHERE t.atuacao = :atuacao")
    , @NamedQuery(name = "TbSolicitantePerfil.findByAtivo", query = "SELECT t FROM TbSolicitantePerfil t WHERE t.ativo = :ativo")
    , @NamedQuery(name = "TbSolicitantePerfil.findByEquipe", query = "SELECT t FROM TbSolicitantePerfil t WHERE t.equipe = :equipe")})
public class TbSolicitantePerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "pessoa")
    private Integer pessoa;
    @Size(max = 6)
    @Column(name = "cbo")
    private String cbo;
    @Size(max = 15)
    @Column(name = "registroprof")
    private String registroprof;
    @Column(name = "tipoProfissional")
    private Integer tipoProfissional;
    @Column(name = "atuacao")
    private Integer atuacao;
    @Column(name = "ativo")
    private Integer ativo;
    @Column(name = "equipe")
    private Integer equipe;
    

    public TbSolicitantePerfil() {
    }

    public TbSolicitantePerfil(Integer codigo) {
        this.codigo = codigo;
    }

    public TbSolicitantePerfil(Integer codigo, Date dataAtualizacao) {
        this.codigo = codigo;
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getPessoa() {
        return pessoa;
    }

    public void setPessoa(Integer pessoa) {
        this.pessoa = pessoa;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getRegistroprof() {
        return registroprof;
    }

    public void setRegistroprof(String registroprof) {
        this.registroprof = registroprof;
    }

    public Integer getTipoProfissional() {
        return tipoProfissional;
    }

    public void setTipoProfissional(Integer tipoProfissional) {
        this.tipoProfissional = tipoProfissional;
    }

    public Integer getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(Integer atuacao) {
        this.atuacao = atuacao;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Integer getEquipe() {
        return equipe;
    }

    public void setEquipe(Integer equipe) {
        this.equipe = equipe;
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
        if (!(object instanceof TbSolicitantePerfil)) {
            return false;
        }
        TbSolicitantePerfil other = (TbSolicitantePerfil) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitantePerfil[ codigo=" + codigo + " ]";
    }
    
}
