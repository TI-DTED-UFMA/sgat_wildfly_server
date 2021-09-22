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
@Table(name = "tb_solicitante_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSolicitantePessoa.findAll", query = "SELECT t FROM TbSolicitantePessoa t")
    , @NamedQuery(name = "TbSolicitantePessoa.findByCodigo", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbSolicitantePessoa.findByNome", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.nome = :nome")
    , @NamedQuery(name = "TbSolicitantePessoa.findBySexo", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.sexo = :sexo")
    , @NamedQuery(name = "TbSolicitantePessoa.findByTelefone", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.telefone = :telefone")
    , @NamedQuery(name = "TbSolicitantePessoa.findByCelular", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.celular = :celular")
    , @NamedQuery(name = "TbSolicitantePessoa.findByCelular2", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.celular2 = :celular2")
    , @NamedQuery(name = "TbSolicitantePessoa.findByEmail", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.email = :email")
    , @NamedQuery(name = "TbSolicitantePessoa.findByEmail2", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.email2 = :email2")
    , @NamedQuery(name = "TbSolicitantePessoa.findByCpf", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.cpf = :cpf")
    , @NamedQuery(name = "TbSolicitantePessoa.findByCns", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.cns = :cns")
    , @NamedQuery(name = "TbSolicitantePessoa.findByOutrodoc", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.outrodoc = :outrodoc")
    , @NamedQuery(name = "TbSolicitantePessoa.findByIbge", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.ibge = :ibge")
    , @NamedQuery(name = "TbSolicitantePessoa.findByEscolaridade", query = "SELECT t FROM TbSolicitantePessoa t WHERE t.escolaridade = :escolaridade")
    })
public class TbSolicitantePessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Column(name = "sexo")
    private Integer sexo;
    @Size(max = 20)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 20)
    @Column(name = "celular")
    private String celular;
    @Size(max = 20)
    @Column(name = "celular2")
    private String celular2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email")
    private String email;
    @Size(max = 40)
    @Column(name = "email2")
    private String email2;
    @Size(max = 11)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 15)
    @Column(name = "cns")
    private String cns;
    @Size(max = 15)
    @Column(name = "outrodoc")
    private String outrodoc;
    @Column(name = "ibge")
    private Integer ibge;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "escolaridade")
    private Integer escolaridade;

    public TbSolicitantePessoa() {
    }

    public TbSolicitantePessoa(Integer codigo) {
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

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

   

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getOutrodoc() {
        return outrodoc;
    }

    public void setOutrodoc(String outrodoc) {
        this.outrodoc = outrodoc;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Integer escolaridade) {
        this.escolaridade = escolaridade;
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
        if (!(object instanceof TbSolicitantePessoa)) {
            return false;
        }
        TbSolicitantePessoa other = (TbSolicitantePessoa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.TbSolicitantePessoa[ codigo=" + codigo + " ]";
    }
    
}
