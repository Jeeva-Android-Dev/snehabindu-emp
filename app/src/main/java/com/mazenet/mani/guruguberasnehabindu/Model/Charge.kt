package com.mazenet.mani.guruguberasnehabindu.Model

data class Charge(val id : Int,
                  val tenant_id : Int,
                  val charge_name : String,
                  val created_by : Int,
                  val created_at : String,
                  val updated_at : String,
                  val updated_by : String,
                  val deleted_by : String?,
                  val deleted_at : String?,
                  val deletion_remark : String?,
                  val status : Int,
                  val tenant_info : TenantInfo,
                  val tenant_det : TenantDet
)

