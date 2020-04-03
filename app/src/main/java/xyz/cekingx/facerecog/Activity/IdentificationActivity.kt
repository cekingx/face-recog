package xyz.cekingx.facerecog.Activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_identification.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import xyz.cekingx.facerecog.Interface.IdentificationService
import xyz.cekingx.facerecog.R
import xyz.cekingx.facerecog.UploadRequestBody
import xyz.cekingx.facerecog.getFileName
import xyz.cekingx.facerecog.snackbar
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.cekingx.facerecog.Entity.IdentificationResponse

class IdentificationActivity : AppCompatActivity(),
    UploadRequestBody.UploadCallback {

    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identification)

        foto.setOnClickListener {
            openImageChooser()
        }

        identification_button.setOnClickListener {
            uploadImage()
//            val intent = Intent(this, IdentificationResultActivity::class.java)
//            startActivity(intent)
        }
    }

    private fun openImageChooser() {
        Intent(Intent.ACTION_PICK).also {
            it.type = "image/*"
            val mimeTypes = arrayOf("image/jpeg", "image/png")
            it.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            startActivityForResult(it, NikInputActivity.REQUEST_CODE_PICK_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_PICK_IMAGE -> {
                    selectedImageUri = data?.data
                    foto.setImageURI(selectedImageUri)
                }
            }
        }
    }

    private fun uploadImage() {
        if (selectedImageUri == null) {
            identification_root_layout.snackbar("Select an Image First")
            return
        }

        val parcelFileDescriptor =
            contentResolver.openFileDescriptor(selectedImageUri!!, "r", null) ?: return

        val inputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
        val file = File(cacheDir, contentResolver.getFileName(selectedImageUri!!))
        val outputStream = FileOutputStream(file)
        inputStream.copyTo(outputStream)

        Log.d("test", "Here1")

        val kecamatan = kecamatan_input.text.toString()
        val tanggalLahir = tanggal_lahir_input.text.toString()

        Log.d("test", "Here2")
        progress_bar.progress = 0
        val body = UploadRequestBody(file, "image", this)
        IdentificationService().uploadImage(
            MultipartBody.Part.createFormData(
                "foto",
                file.name,
                body
            ),
            kecamatan.toRequestBody("multipart/form-data".toMediaType()),
            tanggalLahir.toRequestBody("multipart/form-data".toMediaType())
        ).enqueue(object : Callback<IdentificationResponse> {
            override fun onFailure(call: Call<IdentificationResponse>, t: Throwable) {
                identification_root_layout.snackbar(t.message!!)
                progress_bar.progress = 0
            }

            override fun onResponse(
                call: Call<IdentificationResponse>,
                response: Response<IdentificationResponse>
            ) {
                response.body()?.let {
                    progress_bar.progress = 100
                    val intent = Intent(this@IdentificationActivity, IdentificationResultActivity::class.java).apply {
                        putExtra("url", it.url)
                    }
                    startActivity(intent)
                }
            }

        })
    }

    override fun onProgressUpdate(percentage: Int) {
        progress_bar.progress = percentage
    }

    companion object {
        const val REQUEST_CODE_PICK_IMAGE = 101
    }
}
