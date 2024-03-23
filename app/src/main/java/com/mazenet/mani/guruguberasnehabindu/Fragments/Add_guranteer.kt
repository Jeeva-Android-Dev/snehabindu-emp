package com.mazenet.mani.guruguberasnehabindu.Fragments

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.mazenet.mani.guruguberasnehabindu.Activities.HomeActivity
import com.mazenet.mani.guruguberasnehabindu.R
import com.mazenet.mani.guruguberasnehabindu.Utilities.Constants

class Add_guranteer : BaseFragment() {
    lateinit var guaranteadress: EditText
    lateinit var guarantename: EditText
    lateinit var guarantename1: EditText
    lateinit var guarantename2: EditText
    lateinit var guarantemobile: EditText

    lateinit var guarantemobile1: EditText
    lateinit var guaranteaddress1: EditText

    lateinit var gurantemobile2: EditText
    lateinit var guranteaddress2: EditText

    lateinit var Cus_nametv: TextView
    lateinit var Cus_idtv: TextView
    lateinit var Cus_mobiletv: TextView

    lateinit var gsubmit: Button
    lateinit var gloc_photobutton: Button
    lateinit var gloc_photobutton1: Button
    lateinit var gloc_photobutton2: Button


    lateinit var imageview1: ImageView
    lateinit var imageview2: ImageView
    lateinit var imageview3: ImageView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View
        view = inflater.inflate(R.layout.add_guranter_fragment, container, false)
        (activity as HomeActivity).setActionBarTitle("Add Guranter")
        guarantename = view.findViewById(R.id.g_name) as EditText
        guarantemobile = view.findViewById(R.id.g_mobileno) as EditText
        guaranteadress = view.findViewById(R.id.g_address) as EditText
        gloc_photobutton = view.findViewById(R.id.gloc_photobutton) as Button
        imageview1 = view.findViewById(R.id.glocation1_browse) as ImageView

        gloc_photobutton.setOnClickListener {
            showImagePickerDialog(IMAGE_REQUEST_1)

        }


        guarantename1 = view.findViewById(R.id.g_name2) as EditText
        guarantemobile1 = view.findViewById(R.id.g2_mobileno) as EditText
        guaranteaddress1 = view.findViewById(R.id.g2_address) as EditText
        gloc_photobutton1 = view.findViewById(R.id.gloc_photobutton2) as Button
        imageview2 = view.findViewById(R.id.glocation2_browse) as ImageView

        gloc_photobutton1.setOnClickListener {
            showImagePickerDialog(IMAGE_REQUEST_2)

        }


        guarantename2 = view.findViewById(R.id.g_name3) as EditText
        gurantemobile2 = view.findViewById(R.id.g3_mobileno) as EditText
        guranteaddress2 = view.findViewById(R.id.g3_address) as EditText
        gloc_photobutton2 = view.findViewById(R.id.gloc_photobutton3) as Button
        imageview3 = view.findViewById(R.id.glocation3_browse) as ImageView

        gloc_photobutton2.setOnClickListener {
            showImagePickerDialog(IMAGE_REQUEST_3)

        }


        Cus_nametv = view.findViewById(R.id.txt__cusname) as TextView
        Cus_idtv = view.findViewById(R.id.txt__custid) as TextView
        Cus_mobiletv = view.findViewById(R.id.txt__cusmobile) as TextView

        Cus_nametv.text = getPrefsString(Constants.username, "")
        Cus_idtv.text = getPrefsString(Constants.tenantid, "")
        Cus_mobiletv.text =getPrefsString("tenant_phone", "")


        gsubmit = view.findViewById(R.id.buttonui) as Button
        gsubmit.setOnClickListener {
            toast("Submitted Successfully")
        }

        return view

    }

    private fun showImagePickerDialog(requestCode: Int) {
        val items = arrayOf("Camera", "Gallery","PDF")
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Choose an option")
            .setItems(items) { _, which ->
                when (which) {
                    0 -> checkCameraPermission(requestCode)
                    1 -> openGallery(requestCode)
                    2 -> openPdfPicker(requestCode)
                }
            }
        builder.create().show()
    }
    private  fun openPdfPicker(requestCode: Int){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "application/pdf"
        startActivityForResult(intent,requestCode)
    }
    private fun checkCameraPermission(requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openCamera(requestCode)
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_REQUEST
            )
        }
    }

    private fun openCamera(requestCode: Int) {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, requestCode)
    }

    private fun openGallery(requestCode: Int) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            val imageView = when (requestCode) {
                IMAGE_REQUEST_1 -> imageview1
                IMAGE_REQUEST_2 -> imageview2
                IMAGE_REQUEST_3 -> imageview3

                else -> null
            }

            imageView?.let {
                if (requestCode == CAMERA_REQUEST) {
                    // Handle camera capture result
                    val imageBitmap = data.extras?.get("data") as Bitmap?
                    if(imageBitmap != null){
                        it.setImageBitmap(imageBitmap)
                    } else {
                        data.data?.let { uri ->
                            val  bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver,uri)
                            it.setImageBitmap(bitmap)

                        }

                    }
                } else {
                    // Handle gallery selection result
                    data.data?.let { uri ->
                        val bitmap =
                            MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri)
                        imageView.let { updateImageView(it, data) }
                    }
                }
            }
        }
    }

    private fun updateImageView(imageView: ImageView, data: Intent) {
        when (imageView) {
            imageview1, imageview2, imageview3 -> {
                data.data?.let { uri ->
                    val bitmap =
                        MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri)
                    imageView.setImageBitmap(bitmap)
                }
            }
        }
    }

    companion object {
        private const val CAMERA_PERMISSION_CODE = 101
        private const val IMAGE_REQUEST_1 = 1
        private const val IMAGE_REQUEST_2 = 2
        private const val IMAGE_REQUEST_3 = 3
        private const val CAMERA_REQUEST = 999

    }
}



