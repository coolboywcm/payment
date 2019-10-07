package com.payment.model;

public class PyTerminalAdimg {
    private String id;

    private String adimgId;

    private String terminalId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdimgId() {
        return adimgId;
    }

    public void setAdimgId(String adimgId) {
        this.adimgId = adimgId == null ? null : adimgId.trim();
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId == null ? null : terminalId.trim();
    }
}