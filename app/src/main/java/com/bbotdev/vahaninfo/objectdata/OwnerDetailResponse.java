package com.bbotdev.vahaninfo.objectdata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OwnerDetailResponse {

    @SerializedName("ResponseCode")
    private String responseCode;

    @SerializedName("data")
    private List<DataItem> data;

    @SerializedName("ResponseMessage")
    private String responseMessage;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return
                "OwnerDetailResponse{" +
                        "responseCode = '" + responseCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",responseMessage = '" + responseMessage + '\'' +
                        "}";
    }
}