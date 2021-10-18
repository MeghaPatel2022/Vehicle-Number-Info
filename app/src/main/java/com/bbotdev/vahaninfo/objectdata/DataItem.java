package com.bbotdev.vahaninfo.objectdata;

import com.google.gson.annotations.SerializedName;

public class DataItem {

    @SerializedName("policy_no")
    private String policyNo;

    @SerializedName("owner_name")
    private String ownerName;

    @SerializedName("reg_no")
    private String regNo;

    @SerializedName("insUpto")
    private String insUpto;

    @SerializedName("chasi_no")
    private String chasiNo;

    @SerializedName("own_json")
    private Object ownJson;

    @SerializedName("maker")
    private String maker;

    @SerializedName("puc_upto")
    private String pucUpto;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("regn_dt")
    private String regnDt;

    @SerializedName("rto")
    private String rto;

    @SerializedName("vehicle_age")
    private String vehicleAge;

    @SerializedName("insurance_comp")
    private String insuranceComp;

    @SerializedName("parivahan_json")
    private Object parivahanJson;

    @SerializedName("engine_no")
    private String engineNo;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("state")
    private String state;

    @SerializedName("fuel_type")
    private String fuelType;

    @SerializedName("status")
    private String status;

    @SerializedName("vh_class")
    private String vhClass;

    @SerializedName("puc_no")
    private String pucNo;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getInsUpto() {
        return insUpto;
    }

    public void setInsUpto(String insUpto) {
        this.insUpto = insUpto;
    }

    public String getChasiNo() {
        return chasiNo;
    }

    public void setChasiNo(String chasiNo) {
        this.chasiNo = chasiNo;
    }

    public Object getOwnJson() {
        return ownJson;
    }

    public void setOwnJson(Object ownJson) {
        this.ownJson = ownJson;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getPucUpto() {
        return pucUpto;
    }

    public void setPucUpto(String pucUpto) {
        this.pucUpto = pucUpto;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getRegnDt() {
        return regnDt;
    }

    public void setRegnDt(String regnDt) {
        this.regnDt = regnDt;
    }

    public String getRto() {
        return rto;
    }

    public void setRto(String rto) {
        this.rto = rto;
    }

    public String getVehicleAge() {
        return vehicleAge;
    }

    public void setVehicleAge(String vehicleAge) {
        this.vehicleAge = vehicleAge;
    }

    public String getInsuranceComp() {
        return insuranceComp;
    }

    public void setInsuranceComp(String insuranceComp) {
        this.insuranceComp = insuranceComp;
    }

    public Object getParivahanJson() {
        return parivahanJson;
    }

    public void setParivahanJson(Object parivahanJson) {
        this.parivahanJson = parivahanJson;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVhClass() {
        return vhClass;
    }

    public void setVhClass(String vhClass) {
        this.vhClass = vhClass;
    }

    public String getPucNo() {
        return pucNo;
    }

    public void setPucNo(String pucNo) {
        this.pucNo = pucNo;
    }

    @Override
    public String toString() {
        return
                "DataItem{" +
                        "policy_no = '" + policyNo + '\'' +
                        ",owner_name = '" + ownerName + '\'' +
                        ",reg_no = '" + regNo + '\'' +
                        ",insUpto = '" + insUpto + '\'' +
                        ",chasi_no = '" + chasiNo + '\'' +
                        ",own_json = '" + ownJson + '\'' +
                        ",maker = '" + maker + '\'' +
                        ",puc_upto = '" + pucUpto + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",regn_dt = '" + regnDt + '\'' +
                        ",rto = '" + rto + '\'' +
                        ",vehicle_age = '" + vehicleAge + '\'' +
                        ",insurance_comp = '" + insuranceComp + '\'' +
                        ",parivahan_json = '" + parivahanJson + '\'' +
                        ",engine_no = '" + engineNo + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",state = '" + state + '\'' +
                        ",fuel_type = '" + fuelType + '\'' +
                        ",status = '" + status + '\'' +
                        ",vh_class = '" + vhClass + '\'' +
                        ",puc_no = '" + pucNo + '\'' +
                        "}";
    }
}