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
@Table(name = "tb_solicitacao_resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitacaoResposta.findAll", query = "SELECT t FROM TbSolicitacaoResposta t")
    , @NamedQuery(name = "TbSolicitacaoResposta.findByCodigo", query = "SELECT t FROM TbSolicitacaoResposta t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitacaoResposta.findByCodigoTeleconsultor", query = "SELECT t FROM TbSolicitacaoResposta t WHERE t.codigoTeleconsultor = :codigoTeleconsultor")
    , @NamedQuery(name = "TbSolicitacaoResposta.findBySolicitacaoRepetida", query = "SELECT t FROM TbSolicitacaoResposta t WHERE t.solicitacaoRepetida = :solicitacaoRepetida")
    , @NamedQuery(name = "TbSolicitacaoResposta.findBySolsofcod", query = "SELECT t FROM TbSolicitacaoResposta t WHERE t.solsofcod = :solsofcod")
    , @NamedQuery(name = "TbSolicitacaoResposta.findByRespostaAceita", query = "SELECT t FROM TbSolicitacaoResposta t WHERE t.respostaAceita = :respostaAceita")})
public class TbSolicitacaoResposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "codigoTeleconsultor")
    private Integer codigoTeleconsultor;
    @Column(name = "solicitacaoRepetida")
    private Integer solicitacaoRepetida;
    @Lob
    @Size(max = 65535)
    @Column(name = "justificativaDevolucaoTeleconsultor")
    private String justificativaDevolucaoTeleconsultor;
    @Lob
    @Size(max = 65535)
    @Column(name = "solicitacaoResposta")
    private String solicitacaoResposta;
    @Lob
    @Size(max = 65535)
    @Column(name = "solicitacaoComplemento")
    private String solicitacaoComplemento;
    @Lob
    @Size(max = 65535)
    @Column(name = "solicitacaoAtributos")
    private String solicitacaoAtributos;
    @Lob
    @Size(max = 65535)
    @Column(name = "solicitacaoEduPermanente")
    private String solicitacaoEduPermanente;
    @Lob
    @Size(max = 65535)
    @Column(name = "solicitacaoReferencia")
    private String solicitacaoReferencia;
    @Lob
    @Size(max = 65535)
    @Column(name = "estrategiaBusca")
    private String estrategiaBusca;
    @Column(name = "solsofcod")
    private Integer solsofcod;
    @Column(name = "respostaAceita")
    private Integer respostaAceita;

    public TbSolicitacaoResposta() {
    }

    public TbSolicitacaoResposta(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoTeleconsultor() {
        return codigoTeleconsultor;
    }

    public void setCodigoTeleconsultor(Integer codigoTeleconsultor) {
        this.codigoTeleconsultor = codigoTeleconsultor;
    }

    public Integer getSolicitacaoRepetida() {
        return solicitacaoRepetida;
    }

    public void setSolicitacaoRepetida(Integer solicitacaoRepetida) {
        this.solicitacaoRepetida = solicitacaoRepetida;
    }

    public String getJustificativaDevolucaoTeleconsultor() {
        return justificativaDevolucaoTeleconsultor;
    }

    public void setJustificativaDevolucaoTeleconsultor(String justificativaDevolucaoTeleconsultor) {
        this.justificativaDevolucaoTeleconsultor = justificativaDevolucaoTeleconsultor;
    }

    public String getSolicitacaoResposta() {
        return solicitacaoResposta;
    }

    public void setSolicitacaoResposta(String solicitacaoResposta) {
        this.solicitacaoResposta = solicitacaoResposta;
    }

    public String getSolicitacaoComplemento() {
        return solicitacaoComplemento;
    }

    public void setSolicitacaoComplemento(String solicitacaoComplemento) {
        this.solicitacaoComplemento = solicitacaoComplemento;
    }

    public String getSolicitacaoAtributos() {
        return solicitacaoAtributos;
    }

    public void setSolicitacaoAtributos(String solicitacaoAtributos) {
        this.solicitacaoAtributos = solicitacaoAtributos;
    }

    public String getSolicitacaoEduPermanente() {
        return solicitacaoEduPermanente;
    }

    public void setSolicitacaoEduPermanente(String solicitacaoEduPermanente) {
        this.solicitacaoEduPermanente = solicitacaoEduPermanente;
    }

    public String getSolicitacaoReferencia() {
        return solicitacaoReferencia;
    }

    public void setSolicitacaoReferencia(String solicitacaoReferencia) {
        this.solicitacaoReferencia = solicitacaoReferencia;
    }

    public String getEstrategiaBusca() {
        return estrategiaBusca;
    }

    public void setEstrategiaBusca(String estrategiaBusca) {
        this.estrategiaBusca = estrategiaBusca;
    }

    public Integer getSolsofcod() {
        return solsofcod;
    }

    public void setSolsofcod(Integer solsofcod) {
        this.solsofcod = solsofcod;
    }

    public Integer getRespostaAceita() {
        return respostaAceita;
    }

    public void setRespostaAceita(Integer respostaAceita) {
        this.respostaAceita = respostaAceita;
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
        if (!(object instanceof TbSolicitacaoResposta)) {
            return false;
        }
        TbSolicitacaoResposta other = (TbSolicitacaoResposta) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitacaoResposta[ codigo=" + codigo + " ]";
    }
    
}
