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
import javax.persistence.Lob;
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
@Table(name = "tb_solicitante_unidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitanteUnidade.findAll", query = "SELECT t FROM TbSolicitanteUnidade t")
    , @NamedQuery(name = "TbSolicitanteUnidade.findByCodigo", query = "SELECT t FROM TbSolicitanteUnidade t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitanteUnidade.findByCnes", query = "SELECT t FROM TbSolicitanteUnidade t WHERE t.cnes = :cnes")
    , @NamedQuery(name = "TbSolicitanteUnidade.findByTipo", query = "SELECT t FROM TbSolicitanteUnidade t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TbSolicitanteUnidade.findByEndereco", query = "SELECT t FROM TbSolicitanteUnidade t WHERE t.endereco = :endereco")
    , @NamedQuery(name = "TbSolicitanteUnidade.findByTelefone", query = "SELECT t FROM TbSolicitanteUnidade t WHERE t.telefone = :telefone")
    , @NamedQuery(name = "TbSolicitanteUnidade.findByIbge", query = "SELECT t FROM TbSolicitanteUnidade t WHERE t.ibge = :ibge")
    , @NamedQuery(name = "TbSolicitanteUnidade.findByAtivo", query = "SELECT t FROM TbSolicitanteUnidade t WHERE t.ativo = :ativo")
    , @NamedQuery(name = "TbSolicitanteUnidade.findByDataAtualizacao", query = "SELECT t FROM TbSolicitanteUnidade t WHERE t.dataAtualizacao = :dataAtualizacao")})
public class TbSolicitanteUnidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Lob
    @Size(max = 65535)
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnes")
    private Integer cnes;
    @Column(name = "tipo")
    private Integer tipo;
    @Size(max = 70)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 15)
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "ibge")
    private Integer ibge;
    @Column(name = "ativo")
    private Integer ativo;
    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

    public TbSolicitanteUnidade() {
    }

    public TbSolicitanteUnidade(Integer codigo) {
        this.codigo = codigo;
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

    public Integer getCnes() {
        return cnes;
    }

    public void setCnes(Integer cnes) {
        this.cnes = cnes;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
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
        if (!(object instanceof TbSolicitanteUnidade)) {
            return false;
        }
        TbSolicitanteUnidade other = (TbSolicitanteUnidade) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitanteUnidade[ codigo=" + codigo + " ]";
    }
    
}
