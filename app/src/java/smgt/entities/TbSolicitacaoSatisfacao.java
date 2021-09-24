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
@Table(name = "tb_solicitacao_satisfacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitacaoSatisfacao.findAll", query = "SELECT t FROM TbSolicitacaoSatisfacao t")
    , @NamedQuery(name = "TbSolicitacaoSatisfacao.findByCodigo", query = "SELECT t FROM TbSolicitacaoSatisfacao t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitacaoSatisfacao.findBySatisfacaoResposta", query = "SELECT t FROM TbSolicitacaoSatisfacao t WHERE t.satisfacaoResposta = :satisfacaoResposta")
    , @NamedQuery(name = "TbSolicitacaoSatisfacao.findByClassificacaoResposta", query = "SELECT t FROM TbSolicitacaoSatisfacao t WHERE t.classificacaoResposta = :classificacaoResposta")
    , @NamedQuery(name = "TbSolicitacaoSatisfacao.findByEvitacaoEncaminhamento", query = "SELECT t FROM TbSolicitacaoSatisfacao t WHERE t.evitacaoEncaminhamento = :evitacaoEncaminhamento")
    , @NamedQuery(name = "TbSolicitacaoSatisfacao.findByInducaoEncaminhamento", query = "SELECT t FROM TbSolicitacaoSatisfacao t WHERE t.inducaoEncaminhamento = :inducaoEncaminhamento")})
public class TbSolicitacaoSatisfacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "satisfacaoResposta")
    private Integer satisfacaoResposta;
    @Column(name = "classificacaoResposta")
    private Integer classificacaoResposta;
    @Lob
    @Size(max = 65535)
    @Column(name = "criticasSugestoes")
    private String criticasSugestoes;
    @Column(name = "evitacaoEncaminhamento")
    private Integer evitacaoEncaminhamento;
    @Column(name = "inducaoEncaminhamento")
    private Integer inducaoEncaminhamento;

    public TbSolicitacaoSatisfacao() {
    }

    public TbSolicitacaoSatisfacao(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getSatisfacaoResposta() {
        return satisfacaoResposta;
    }

    public void setSatisfacaoResposta(Integer satisfacaoResposta) {
        this.satisfacaoResposta = satisfacaoResposta;
    }

    public Integer getClassificacaoResposta() {
        return classificacaoResposta;
    }

    public void setClassificacaoResposta(Integer classificacaoResposta) {
        this.classificacaoResposta = classificacaoResposta;
    }

    public String getCriticasSugestoes() {
        return criticasSugestoes;
    }

    public void setCriticasSugestoes(String criticasSugestoes) {
        this.criticasSugestoes = criticasSugestoes;
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
        if (!(object instanceof TbSolicitacaoSatisfacao)) {
            return false;
        }
        TbSolicitacaoSatisfacao other = (TbSolicitacaoSatisfacao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitacaoSatisfacao[ codigo=" + codigo + " ]";
    }
    
}
