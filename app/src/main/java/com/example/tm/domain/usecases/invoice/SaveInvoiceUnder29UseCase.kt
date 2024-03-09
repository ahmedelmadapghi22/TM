package com.example.tm.domain.usecases.invoice

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.drawToBitmap
import com.example.tm.R
import com.example.tm.domain.usecases.Preconditions
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import javax.inject.Inject

class SaveInvoiceAbove29UseCase @Inject constructor(@ApplicationContext private val context: Context) {

    operator fun invoke(
        customerName: String,
        materialName: String,
        totalMeters: String,
        totalWeight: String,
        price: String,
        view: ViewGroup
    ): Int {
        if (Preconditions.checkFiled(customerName)) {
            Log.d("???????????????", "Error:customerName")

            return R.string.err_customer_name
        } else if (Preconditions.checkFiled(materialName)) {
            return R.string.err_material_name
        } else if (Preconditions.checkFiled(totalMeters)) {
            return R.string.err_total_meters
        } else if (Preconditions.checkFiled(totalWeight)) {
            return R.string.err_total_weight
        } else if (Preconditions.checkFiled(price)) {
            return R.string.err_pirce
        } else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val resolver = context.contentResolver
                val contentValues = ContentValues().apply {
                    put(MediaStore.Images.Media.DISPLAY_NAME, customerName)
                    put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                    put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                }
                val imageUri =
                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                imageUri?.let {
                    val outputStream: OutputStream? = resolver.openOutputStream(it)
                    outputStream?.use { stream ->
                        view.drawToBitmap().compress(Bitmap.CompressFormat.JPEG, 100, stream)
                    }
                }

            return 1
            }
            else {
                val storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                val imageFile = File(storageDirectory, customerName)

                try {
                    val fileOutputStream = FileOutputStream(imageFile)
                    view.drawToBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                    fileOutputStream.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return 2

            }
        }
    }


}