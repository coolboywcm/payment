package com.payment.model;

public class SysDictionaries {
    private String zdId;

    private String name;

    private String bianma;

    private Integer ordyBy;

    private String parentId;

    private Integer jb;

    private String pBm;

    public String getZdId() {
        return zdId;
    }

    public void setZdId(String zdId) {
        this.zdId = zdId == null ? null : zdId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBianma() {
        return bianma;
    }

    public void setBianma(String bianma) {
        this.bianma = bianma == null ? null : bianma.trim();
    }

    public Integer getOrdyBy() {
        return ordyBy;
    }

    public void setOrdyBy(Integer ordyBy) {
        this.ordyBy = ordyBy;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getJb() {
        return jb;
    }

    public void setJb(Integer jb) {
        this.jb = jb;
    }

    public String getpBm() {
        return pBm;
    }

    public void setpBm(String pBm) {
        this.pBm = pBm == null ? null : pBm.trim();
    }
}