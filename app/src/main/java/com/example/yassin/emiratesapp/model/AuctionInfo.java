package com.example.yassin.emiratesapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *Created by yassin on 7/10/18.
 */

public class AuctionInfo {

    @SerializedName("bids")
    @Expose
    private Integer bids;
    @SerializedName("endDate")
    @Expose
    private Integer endDate;
    @SerializedName("endDateEn")
    @Expose
    private String endDateEn;
    @SerializedName("endDateAr")
    @Expose
    private String endDateAr;
    @SerializedName("currencyEn")
    @Expose
    private String currencyEn;
    @SerializedName("currencyAr")
    @Expose
    private String currencyAr;
    @SerializedName("currentPrice")
    @Expose
    private Integer currentPrice;
    @SerializedName("minIncrement")
    @Expose
    private Integer minIncrement;
    @SerializedName("lot")
    @Expose
    private Integer lot;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("VATPercent")
    @Expose
    private Integer vATPercent;
    @SerializedName("isModified")
    @Expose
    private Integer isModified;
    @SerializedName("itemid")
    @Expose
    private Integer itemid;
    @SerializedName("iCarId")
    @Expose
    private Integer iCarId;
    @SerializedName("iVinNumber")
    @Expose
    private String iVinNumber;

    public Integer getBids() {
        return bids;
    }

    public void setBids(Integer bids) {
        this.bids = bids;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public String getEndDateEn() {
        return endDateEn;
    }

    public void setEndDateEn(String endDateEn) {
        this.endDateEn = endDateEn;
    }

    public String getEndDateAr() {
        return endDateAr;
    }

    public void setEndDateAr(String endDateAr) {
        this.endDateAr = endDateAr;
    }

    public String getCurrencyEn() {
        return currencyEn;
    }

    public void setCurrencyEn(String currencyEn) {
        this.currencyEn = currencyEn;
    }

    public String getCurrencyAr() {
        return currencyAr;
    }

    public void setCurrencyAr(String currencyAr) {
        this.currencyAr = currencyAr;
    }

    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getMinIncrement() {
        return minIncrement;
    }

    public void setMinIncrement(Integer minIncrement) {
        this.minIncrement = minIncrement;
    }

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lot) {
        this.lot = lot;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getVATPercent() {
        return vATPercent;
    }

    public void setVATPercent(Integer vATPercent) {
        this.vATPercent = vATPercent;
    }

    public Integer getIsModified() {
        return isModified;
    }

    public void setIsModified(Integer isModified) {
        this.isModified = isModified;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getICarId() {
        return iCarId;
    }

    public void setICarId(Integer iCarId) {
        this.iCarId = iCarId;
    }

    public String getIVinNumber() {
        return iVinNumber;
    }

    public void setIVinNumber(String iVinNumber) {
        this.iVinNumber = iVinNumber;
    }
}
