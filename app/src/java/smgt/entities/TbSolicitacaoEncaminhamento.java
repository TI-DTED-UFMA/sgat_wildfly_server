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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nigel
 */
@Entity
@Table(name = "tb_solicitacao_encaminhamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitacaoEncaminhamento.findAll", query = "SELECT t FROM TbSolicitacaoEncaminhamento t")
    , @NamedQuery(name = "TbSolicitacaoEncaminhamento.findByCodigo", query = "SELECT t FROM TbSolicitacaoEncaminhamento t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitacaoEncaminhamento.findByIntencaoEncaminhamento", query = "SELECT t FROM TbSolicitacaoEncaminhamento t WHERE t.intencaoEncaminhamento = :intencaoEncaminhamento")
    , @NamedQuery(name = "TbSolicitacaoEncaminhamento.findBySugestaoEncaminhamento", query = "SELECT t FROM TbSolicitacaoEncaminhamento t WHERE t.sugestaoEncaminhamento = :sugestaoEncaminhamento")
    , @NamedQuery(name = "TbSolicitacaoEncaminhamento.findByCodigoSugestaoEncaminhamento", query = "SELECT t FROM TbSolicitacaoEncaminhamento t WHERE t.codigoSugestaoEncaminhamento = :codigoSugestaoEncaminhamento")
    , @NamedQuery(name = "TbSolicitacaoEncaminhamento.findByCboEspecialidade", query = "SELECT t FROM TbSolicitacaoEncaminhamento t WHERE t.cboEspecialidade = :cboEspecialidade")
    , @NamedQuery(name = "TbSolicitacaoEncaminhamento.findByEvitacaoEncaminhamento", query = "SELECT t FROM TbSolicitacaoEncaminhamento t WHERE t.evitacaoEncaminhamento = :evitacaoEncaminhamento")
    , @NamedQuery(name = "TbSolicitacaoEncaminhamento.findByInducaoEncaminhamento", query = "SELECT t FROM TbSolicitacaoEncaminhamento t WHERE t.inducaoEncaminhamento = :inducaoEncaminhamento")})
public class TbSolicitacaoEncaminhamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "intencaoEncaminhamento")
    private Integer intencaoEncaminhamento;
    @Column(name = "sugestaoEncaminhamento")
    private Integer sugestaoEncaminhamento;
    @Column(name = "codigoSugestaoEncaminhamento")
    private Integer codigoSugestaoEncaminhamento;
    @Column(name = "cboEspecialidade")
    private Integer cboEspecialidade;
    @Column(name = "evitacaoEncaminhamento")
    private Integer evitacaoEncaminhamento;
    @Column(name = "inducaoEncaminhamento")
    private Integer inducaoEncaminhamento;

    public TbSolicitacaoEncaminhamento() {
    }

    public TbSolicitacaoEncaminhamento(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getIntencaoEncaminhamento() {
        return intencaoEncaminhamento;
    }

    public void setIntencaoEncaminhamento(Integer intencaoEncaminhamento) {
        this.intencaoEncaminhamento = intencaoEncaminhamento;
    }

    public Integer getSugestaoEncaminhamento() {
        return sugestaoEncaminhamento;
    }

    public void setSugestaoEncaminhamento(Integer sugestaoEncaminhamento) {
        this.sugestaoEncaminhamento = sugestaoEncaminhamento;
    }

    public Integer getCodigoSugestaoEncaminhamento() {
        return codigoSugestaoEncaminhamento;
    }

    public void setCodigoSugestaoEncaminhamento(Integer codigoSugestaoEncaminhamento) {
        this.codigoSugestaoEncaminhamento = codigoSugestaoEncaminhamento;
    }

    public Integer getCboEspecialidade() {
        return cboEspecialidade;
    }

    public void setCboEspecialidade(Integer cboEspecialidade) {
        this.cboEspecialidade = cboEspecialidade;
    }

    public Integer getEvitacaoEncaminhamento() {
        return evitacaoEncaminhamento;
    }

    public void setEvitacaoEncaminhamento(Integer evitacaoEncaminhamento) {
        this.evitacaoEncaminhamento = evitacaoEncaminhamento;
    }

    public Integer getInducaoEncaminhamento() {
        return inducaoEncaminhamento;
    }

    public void setInducaoEncaminhamento(Integer inducaoEncaminhamento) {
        this.inducaoEncaminhamento = inducaoEncaminhamento;
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
        if (!(object instanceof TbSolicitacaoEncaminhamento)) {
            return false;
        }
        TbSolicitacaoEncaminhamento other = (TbSolicitacaoEncaminhamento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitacaoEncaminhamento[ codigo=" + codigo + " ]";
    }
    
}
