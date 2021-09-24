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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nigel
 */
@Entity
@Table(name = "tb_solicitacao_data_timestamp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitacaoDataTimestamp.findAll", query = "SELECT t FROM TbSolicitacaoDataTimestamp t")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findByCodigo", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findBySoldtabertura", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.soldtabertura = :soldtabertura")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findBySoldtenvio", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.soldtenvio = :soldtenvio")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findByRegdtreceb", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.regdtreceb = :regdtreceb")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findByRegdtdevol", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.regdtdevol = :regdtdevol")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findByRegdtenvio", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.regdtenvio = :regdtenvio")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findByConsdtacresp", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.consdtacresp = :consdtacresp")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findByConsdtdevol", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.consdtdevol = :consdtdevol")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findBySoldtenvresp", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.soldtenvresp = :soldtenvresp")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findBySoldtsteleit", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.soldtsteleit = :soldtsteleit")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findBySoldtavalin", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.soldtavalin = :soldtavalin")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findBySoldtavalfim", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.soldtavalfim = :soldtavalfim")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findBySolsitcoddatahoje", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.solsitcoddatahoje = :solsitcoddatahoje")
    , @NamedQuery(name = "TbSolicitacaoDataTimestamp.findBySoldtfinalizacao", query = "SELECT t FROM TbSolicitacaoDataTimestamp t WHERE t.soldtfinalizacao = :soldtfinalizacao")})
public class TbSolicitacaoDataTimestamp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "soldtabertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date soldtabertura;
    @Column(name = "soldtenvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date soldtenvio;
    @Column(name = "regdtreceb")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdtreceb;
    @Column(name = "regdtdevol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdtdevol;
    @Column(name = "regdtenvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdtenvio;
    @Column(name = "consdtacresp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date consdtacresp;
    @Column(name = "consdtdevol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date consdtdevol;
    @Column(name = "soldtenvresp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date soldtenvresp;
    @Column(name = "soldtsteleit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date soldtsteleit;
    @Column(name = "soldtavalin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date soldtavalin;
    @Column(name = "soldtavalfim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date soldtavalfim;
    @Column(name = "solsitcoddatahoje")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solsitcoddatahoje;
    @Column(name = "soldtfinalizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date soldtfinalizacao;

    public TbSolicitacaoDataTimestamp() {
    }

    public TbSolicitacaoDataTimestamp(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getSoldtabertura() {
        return soldtabertura;
    }

    public void setSoldtabertura(Date soldtabertura) {
        this.soldtabertura = soldtabertura;
    }

    public Date getSoldtenvio() {
        return soldtenvio;
    }

    public void setSoldtenvio(Date soldtenvio) {
        this.soldtenvio = soldtenvio;
    }

    public Date getRegdtreceb() {
        return regdtreceb;
    }

    public void setRegdtreceb(Date regdtreceb) {
        this.regdtreceb = regdtreceb;
    }

    public Date getRegdtdevol() {
        return regdtdevol;
    }

    public void setRegdtdevol(Date regdtdevol) {
        this.regdtdevol = regdtdevol;
    }

    public Date getRegdtenvio() {
        return regdtenvio;
    }

    public void setRegdtenvio(Date regdtenvio) {
        this.regdtenvio = regdtenvio;
    }

    public Date getConsdtacresp() {
        return consdtacresp;
    }

    public void setConsdtacresp(Date consdtacresp) {
        this.consdtacresp = consdtacresp;
    }

    public Date getConsdtdevol() {
        return consdtdevol;
    }

    public void setConsdtdevol(Date consdtdevol) {
        this.consdtdevol = consdtdevol;
    }

    public Date getSoldtenvresp() {
        return soldtenvresp;
    }

    public void setSoldtenvresp(Date soldtenvresp) {
        this.soldtenvresp = soldtenvresp;
    }

    public Date getSoldtsteleit() {
        return soldtsteleit;
    }

    public void setSoldtsteleit(Date soldtsteleit) {
        this.soldtsteleit = soldtsteleit;
    }

    public Date getSoldtavalin() {
        return soldtavalin;
    }

    public void setSoldtavalin(Date soldtavalin) {
        this.soldtavalin = soldtavalin;
    }

    public Date getSoldtavalfim() {
        return soldtavalfim;
    }

    public void setSoldtavalfim(Date soldtavalfim) {
        this.soldtavalfim = soldtavalfim;
    }

    public Date getSolsitcoddatahoje() {
        return solsitcoddatahoje;
    }

    public void setSolsitcoddatahoje(Date solsitcoddatahoje) {
        this.solsitcoddatahoje = solsitcoddatahoje;
    }

    public Date getSoldtfinalizacao() {
        return soldtfinalizacao;
    }

    public void setSoldtfinalizacao(Date soldtfinalizacao) {
        this.soldtfinalizacao = soldtfinalizacao;
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
        if (!(object instanceof TbSolicitacaoDataTimestamp)) {
            return false;
        }
        TbSolicitacaoDataTimestamp other = (TbSolicitacaoDataTimestamp) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitacaoDataTimestamp[ codigo=" + codigo + " ]";
    }
    
}
