package com.mazenet.mani.guruguberasnehabindu.Adapters

import android.view.View

interface AdapterEdittextListener {

    fun onPositionClicked(view:View,position:Int,oldvalue:String)
    fun onLongClicked(position:Int)
    fun onEdited(position:Int,value:String)
}