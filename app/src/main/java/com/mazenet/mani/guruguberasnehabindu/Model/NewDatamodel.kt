package com.mazenet.mani.guruguberasnehabindu.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewDatamodel {


        @SerializedName("id")
        @Expose
        private var id: Int? = null
        @SerializedName("tenant_id")
        @Expose
        private var tenantId: Int? = null
        @SerializedName("charge_name")
        @Expose
        private var chargeName: String? = null
        @SerializedName("created_by")
        @Expose
        private var createdBy : Int? = null
        @SerializedName("created_at")
        @Expose
        private var createdAt : String? = null
        @SerializedName("updated_at")
        @Expose
        private var updatedAt : String? = null
         @SerializedName("updated_by")
         @Expose
         private var updatedBy : String? = null
         @SerializedName("deleted_by")
         @Expose
         private var deletedBy : String? = null

        @SerializedName("deleted_by")
        @Expose
        private var deletedAt : String? = null

        @SerializedName("deletion_remark")
        @Expose
        private  var deletionRemark :String? = null
        @SerializedName("tenant_info")
        @Expose
        private var data: ArrayList<TenantInfoModel>? = null
        @SerializedName("tenant_det")
        @Expose
        private var datadet: ArrayList <TenantDetModel>? = null


        /**
         * No args constructor for use in serialization
         *
         */

        /**
         *
         * @param id
         * @param tenantId
         * @param chargeName
         * @param createdBy
         * @param createdAt
         * @param updatedAt
         * @param updatedBy
         * @param deletedBy
         * @param deleted_at
         * @param deletionRemark
         * @param data
         * @param datadet
         */
        fun NewDatamodel(id: Int,
                         tenantId: Int,
                         chargeName : String,
                         createdBy :Int,
                         createdAt :String,
                         updatedAt:String,
                         updatedBy:String,
                         deletedBy:String,
                         deletedAt:String,
                         deletionRemark: String,
                         data: ArrayList<TenantInfoModel>,
                         datadet : ArrayList<TenantDetModel>
                         ) {

            this.id = id
            this.tenantId = tenantId
            this.chargeName = chargeName
            this.createdBy=createdBy
            this.createdAt = createdAt
            this.updatedAt =updatedAt
            this.updatedBy = updatedBy
            this.deletedBy = deletedBy
            this.deletedAt = deletedAt
            this.deletionRemark = deletionRemark
            this.data = data
            this.datadet = datadet
        }


        fun getid(): Int? {
            return id
        }

        fun setid(id: Int) {
            this.id = id
        }
        fun gettenid():Int? {
            return tenantId
        }

        fun settenid(tenantId: Int) {
            this.tenantId = tenantId
        }

        fun getchargename(): String? {
            return chargeName
        }

        fun setchargename(chargeName: String) {
            this.chargeName = chargeName
        }

        fun getData(): ArrayList<TenantInfoModel>? {
            return data
        }

        fun setData(data: ArrayList<TenantInfoModel>) {
            this.data = data
        }

        fun getdatadet(): ArrayList<TenantDetModel>? {
            return datadet
        }
        fun setdatadet(datadet: ArrayList<TenantDetModel>) {
            this.datadet = datadet
        }
    }
