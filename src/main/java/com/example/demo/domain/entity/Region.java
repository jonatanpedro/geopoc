package com.example.demo.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "brasil_simp")
public class Region {

    @Id
    @Column(value = "ogc_fid")
    private Long ogcFid;
    @Column(value = "wkb_geometry")
    private String wkbGeometry;
    private String pais;

    public Region() {
    }

    public Long getOgcFid() {
        return ogcFid;
    }

    public void setOgcFid(Long ogcFid) {
        this.ogcFid = ogcFid;
    }

    public String getWkbGeometry() {
        return wkbGeometry;
    }

    public void setWkbGeometry(String wkbGeometry) {
        this.wkbGeometry = wkbGeometry;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
