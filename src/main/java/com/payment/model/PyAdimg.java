package com.payment.model;

public class PyAdimg {
    private String id;

    private String name;

    private String fileId1;

    private String tip1;

    private String fileId2;

    private String tip2;

    private String fileId3;

    private String tip3;

    private String orgId;

    private String shopId;

    private String terminalId;

    private String orderIndex;

    private String type;

    private String createTime;

    private String createUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFileId1() {
        return fileId1;
    }

    public void setFileId1(String fileId1) {
        this.fileId1 = fileId1 == null ? null : fileId1.trim();
    }

    public String getTip1() {
        return tip1;
    }

    public void setTip1(String tip1) {
        this.tip1 = tip1 == null ? null : tip1.trim();
    }

    public String getFileId2() {
        return fileId2;
    }

    public void setFileId2(String fileId2) {
        this.fileId2 = fileId2 == null ? null : fileId2.trim();
    }

    public String getTip2() {
        return tip2;
    }

    public void setTip2(String tip2) {
        this.tip2 = tip2 == null ? null : tip2.trim();
    }

    public String getFileId3() {
        return fileId3;
    }

    public void setFileId3(String fileId3) {
        this.fileId3 = fileId3 == null ? null : fileId3.trim();
    }

    public String getTip3() {
        return tip3;
    }

    public void setTip3(String tip3) {
        this.tip3 = tip3 == null ? null : tip3.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId == null ? null : terminalId.trim();
    }

    public String getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(String orderIndex) {
        this.orderIndex = orderIndex == null ? null : orderIndex.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }
}