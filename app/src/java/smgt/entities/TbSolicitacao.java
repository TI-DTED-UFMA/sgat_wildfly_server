/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smgt.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nigel
 */
@Entity
@Table(name = "tb_solicitacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitacao.findAll", query = "SELECT t FROM TbSolicitacao t")
    , @NamedQuery(name = "TbSolicitacao.findByCodigo", query = "SELECT t FROM TbSolicitacao t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitacao.findBySolicitacaoTipo", query = "SELECT t FROM TbSolicitacao t WHERE t.solicitacaoTipo = :solicitacaoTipo")
    , @NamedQuery(name = "TbSolicitacao.findBySolicitacaoAtivo", query = "SELECT t FROM TbSolicitacao t WHERE t.solicitacaoAtivo = :solicitacaoAtivo")
    , @NamedQuery(name = "TbSolicitacao.findByCodigoSolicitante", query = "SELECT t FROM TbSolicitacao t WHERE t.codigoSolicitante = :codigoSolicitante")
    , @NamedQuery(name = "TbSolicitacao.findByPacienteAtivo", query = "SELECT t FROM TbSolicitacao t WHERE t.pacienteAtivo = :pacienteAtivo")})
public class TbSolicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "solicitacaoTipo")
    private Integer solicitacaoTipo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "solcitacao")
    private String solcitacao;
    @Column(name = "solicitacaoAtivo")
    private Integer solicitacaoAtivo;
    @Column(name = "codigoSolicitante")
    private Integer codigoSolicitante;
    @Column(name = "pacienteAtivo")
    private Integer pacienteAtivo;

    public TbSolicitacao() {
    }

    public TbSolicitacao(Integer codigo) {
        this.codigo = codigo;
    }

    public TbSolicitacao(Integer codigo, String solcitacao) {
        this.codigo = codigo;
        this.solcitacao = solcitacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getSolicitacaoTipo() {
        return solicitacaoTipo;
    }

    public void setSolicitacaoTipo(Integer solicitacaoTipo) {
        this.solicitacaoTipo = solicitacaoTipo;
    }

    public String getSolcitacao() {
        return solcitacao;
    }

    public void setSolcitacao(String solcitacao) {
        this.solcitacao = solcitacao;
    }

    public Integer getSolicitacaoAtivo() {
        return solicitacaoAtivo;
    }

    public void setSolicitacaoAtivo(Integer solicitacaoAtivo) {
        this.solicitacaoAtivo = solicitacaoAtivo;
    }

    public Integer getCodigoSolicitante() {
        return codigoSolicitante;
    }

    public void setCodigoSolicitante(Integer codigoSolicitante) {
        this.codigoSolicitante = codigoSolicitante;
    }

    public Integer getPacienteAtivo() {
        return pacienteAtivo;
    }

    public void setPacienteAtivo(Integer pacienteAtivo) {
        this.pacienteAtivo = pacienteAtivo;
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
        if (!(object instanceof TbSolicitacao)) {
            return false;
        }
        TbSolicitacao other = (TbSolicitacao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitacao[ codigo=" + codigo + " ]";
    }
    
}
