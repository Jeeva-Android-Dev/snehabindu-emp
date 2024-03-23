package com.mazenet.mani.guruguberasnehabindu.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TenantDetModel {

    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("chit_fund_name ")
    @Expose
    private var chitFundname: String? = null
    @SerializedName("company_logo")
    @Expose
    private var companyLogo: String? = null
    @SerializedName("receipts_logo")
    @Expose
    private var receiptLogo: String? = null
    @SerializedName("favicon")
    @Expose
    private var favicon: String? = null
    @SerializedName("header_name")
    @Expose
    private var headerName: String? = null
    /**
     * No args constructor for use in serialization
     *
     */

    /**
     *
     * @param id
     * @param chitFundname
     * @param companyLogo
     * @param receiptLogo
     * @param favicon
     * @param headerName
     */
    fun TenantDetModel(id: Int,
                   chitFundname: String?,
                   companyLogo: String?,
                   receiptLogo: String?,
                   favicon: String,
                   headerName:String?) {

        this.id = id
        this.chitFundname = chitFundname
        this.companyLogo = companyLogo
        this.receiptLogo = receiptLogo
        this.favicon = favicon
        this.headerName = headerName
    }



    fun getId(): Int? {
        return id
    }

    fun setId(id: Int ?) {
        this.id = id
    }

}
