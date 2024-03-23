package com.mazenet.mani.guruguberasnehabindu.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TenantInfoModel {

    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("chit_fund_name")
    @Expose
    private var chitFundName: String? = null

    /**
     * No args constructor for use in serialization
     *
     */

    /**
     *
     * @param id
     * @param chitFundName
     */
    fun TenantInfoModel(id: Int, chitFundName: String) {

        this.id = id
        this.chitFundName = chitFundName
    }

    fun getid(): Int? {
        return id
    }

    fun setid(id: Int) {
        this.id = id
    }

    fun getchitfundname(): String? {
        return chitFundName
    }

    fun setchitfundname(msg: String) {
        this.chitFundName = chitFundName
    }
}
