package com.mazenet.mani.guruguberasnehabindu.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewOtherChargeData {

    @SerializedName("status")
        @Expose
        private var status: String? = null
        @SerializedName("msg")
        @Expose
        private var msg: String? = null
        @SerializedName("data")
        @Expose
        private var data: ArrayList<NewDatamodel>? = null

        /**
         * No args constructor for use in serialization
         *
         */

        /**
         *
         * @param status
         * @param data
         * @param msg
         */
        fun NewOtherChargeData(status: String, msg: String, data: ArrayList<NewDatamodel>) {

            this.status = status
            this.msg = msg
            this.data = data
        }

        fun getStatus(): String? {
            return status
        }

        fun setStatus(status: String) {
            this.status = status
        }

        fun getMsg(): String? {
            return msg
        }

        fun setMsg(msg: String) {
            this.msg = msg
        }

        fun getData(): ArrayList<NewDatamodel>? {
            return data
        }

        fun setData(data: ArrayList<NewDatamodel>) {
            this.data = data
        }
    }