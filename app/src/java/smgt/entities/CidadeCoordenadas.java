/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smgt.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cidade_coordenadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CidadeCoordenadas.findAll", query = "SELECT c FROM CidadeCoordenadas c")
    , @NamedQuery(name = "CidadeCoordenadas.findByIbge", query = "SELECT c FROM CidadeCoordenadas c WHERE c.ibge = :ibge")
    , @NamedQuery(name = "CidadeCoordenadas.findByMunicipio", query = "SELECT c FROM CidadeCoordenadas c WHERE c.municipio = :municipio")
    , @NamedQuery(name = "CidadeCoordenadas.findByUfId", query = "SELECT c FROM CidadeCoordenadas c WHERE c.ufId = :ufId")
    , @NamedQuery(name = "CidadeCoordenadas.findBySigla", query = "SELECT c FROM CidadeCoordenadas c WHERE c.sigla = :sigla")
    , @NamedQuery(name = "CidadeCoordenadas.findByUf", query = "SELECT c FROM CidadeCoordenadas c WHERE c.uf = :uf")
    , @NamedQuery(name = "CidadeCoordenadas.findByLatitude", query = "SELECT c FROM CidadeCoordenadas c WHERE c.latitude = :latitude")
    , @NamedQuery(name = "CidadeCoordenadas.findByLongitude", query = "SELECT c FROM CidadeCoordenadas c WHERE c.longitude = :longitude")})
public class CidadeCoordenadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ibge")
    private Integer ibge;
    @Size(max = 34)
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "uf_id")
    private Integer ufId;
    @Size(max = 2)
    @Column(name = "sigla")
    private String sigla;
    @Size(max = 19)
    @Column(name = "uf")
    private String uf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Size(max = 13)
    @Column(name = "longitude")
    private String longitude;

    public CidadeCoordenadas() {
    }

    public CidadeCoordenadas(Integer ibge) {
        this.ibge = ibge;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getUfId() {
        return ufId;
    }

    public void setUfId(Integer ufId) {
        this.ufId = ufId;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ibge != null ? ibge.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CidadeCoordenadas)) {
            return false;
        }
        CidadeCoordenadas other = (CidadeCoordenadas) object;
        if ((this.ibge == null && other.ibge != null) || (this.ibge != null && !this.ibge.equals(other.ibge))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smgt.entities.CidadeCoordenadas[ ibge=" + ibge + " ]";
    }
    
}
