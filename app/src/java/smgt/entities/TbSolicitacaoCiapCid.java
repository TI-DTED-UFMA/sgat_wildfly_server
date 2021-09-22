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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nigel
 */
@Entity
@Table(name = "tb_solicitacao_ciap_cid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitacaoCiapCid.findAll", query = "SELECT t FROM TbSolicitacaoCiapCid t")
    , @NamedQuery(name = "TbSolicitacaoCiapCid.findByCodigo", query = "SELECT t FROM TbSolicitacaoCiapCid t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitacaoCiapCid.findByCiap1", query = "SELECT t FROM TbSolicitacaoCiapCid t WHERE t.ciap1 = :ciap1")
    , @NamedQuery(name = "TbSolicitacaoCiapCid.findByCiap2", query = "SELECT t FROM TbSolicitacaoCiapCid t WHERE t.ciap2 = :ciap2")
    , @NamedQuery(name = "TbSolicitacaoCiapCid.findByCiap3", query = "SELECT t FROM TbSolicitacaoCiapCid t WHERE t.ciap3 = :ciap3")
    , @NamedQuery(name = "TbSolicitacaoCiapCid.findByCid1", query = "SELECT t FROM TbSolicitacaoCiapCid t WHERE t.cid1 = :cid1")
    , @NamedQuery(name = "TbSolicitacaoCiapCid.findByCid2", query = "SELECT t FROM TbSolicitacaoCiapCid t WHERE t.cid2 = :cid2")})
public class TbSolicitacaoCiapCid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 4)
    @Column(name = "ciap1")
    private String ciap1;
    @Size(max = 4)
    @Column(name = "ciap2")
    private String ciap2;
    @Size(max = 4)
    @Column(name = "ciap3")
    private String ciap3;
    @Size(max = 4)
    @Column(name = "cid1")
    private String cid1;
    @Size(max = 4)
    @Column(name = "cid2")
    private String cid2;

    public TbSolicitacaoCiapCid() {
    }

    public TbSolicitacaoCiapCid(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCiap1() {
        return ciap1;
    }

    public void setCiap1(String ciap1) {
        this.ciap1 = ciap1;
    }

    public String getCiap2() {
        return ciap2;
    }

    public void setCiap2(String ciap2) {
        this.ciap2 = ciap2;
    }

    public String getCiap3() {
        return ciap3;
    }

    public void setCiap3(String ciap3) {
        this.ciap3 = ciap3;
    }

    public String getCid1() {
        return cid1;
    }

    public void setCid1(String cid1) {
        this.cid1 = cid1;
    }

    public String getCid2() {
        return cid2;
    }

    public void setCid2(String cid2) {
        this.cid2 = cid2;
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
        if (!(object instanceof TbSolicitacaoCiapCid)) {
            return false;
        }
        TbSolicitacaoCiapCid other = (TbSolicitacaoCiapCid) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitacaoCiapCid[ codigo=" + codigo + " ]";
    }
    
}
