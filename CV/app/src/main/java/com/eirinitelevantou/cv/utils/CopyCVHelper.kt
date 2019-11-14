package com.eirinitelevantou.cv.utils

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.*
import androidx.core.content.ContextCompat.getSystemService
import android.app.NotificationManager
import android.content.Intent
import android.app.PendingIntent
import android.content.ActivityNotFoundException
import com.eirinitelevantou.cv.ui.main.MainActivity
import androidx.core.app.NotificationCompat
import com.eirinitelevantou.cv.R
import android.net.Uri
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.FileProvider
import com.eirinitelevantou.cv.BuildConfig


object CopyCVHelper {

    fun copyCV(context: Context, isForEmail:Boolean) {
        val assetManager = context.assets
        val filename = "resume.pdf";
        var stream: InputStream? = null
        var out: OutputStream? = null
        try {
            stream = assetManager.open(filename)
            val outFile =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/" + filename)
            out = FileOutputStream(outFile)
            copyFile(stream!!, out)
        } catch (e: IOException) {
            Log.e("tag", "Failed to copy asset file: $filename", e)
        } finally {
            if (stream != null) {
                try {
                    stream!!.close()
                    stream = null
                } catch (e: IOException) {

                }

            }
            if (out != null) {
                try {
                    out!!.flush()
                    out!!.close()
                    out = null
                } catch (e: IOException) {

                }
            }
            val file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/" + filename);
            if (file.exists()) {
                if(isForEmail){
                    sendEmail(context,file)
                }else {
                    var builder = NotificationCompat.Builder(
                        context,
                        context.getString(R.string.notification_channel_id)
                    )
                        .setSmallIcon(R.drawable.etlogo)
                        .setContentTitle(context.getString(R.string.cv_downloaded))
                        .setContentText(context.getString(R.string.eirini_cv_downloaded))
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                    val path =
                        FileProvider.getUriForFile(
                            context,
                            BuildConfig.APPLICATION_ID + ".provider",
                            file)


                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setDataAndType(path, "application/pdf")
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                    val pi =
                        PendingIntent.getActivity(context, 0, intent, 0)
                    builder.setContentIntent(pi)
                    with(NotificationManagerCompat.from(context)) {
                        // notificationId is a unique int for each notification that you must define
                        notify(0, builder.build())
                    }
                    Toast.makeText(
                        context,
                        context.getString(R.string.download_success),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }else{
                Toast.makeText(
                    context,
                    context.getString(R.string.download_failure),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    @Throws(IOException::class)
    fun copyFile(stream: InputStream, out: OutputStream) {
        val buffer = ByteArray(1024)
        var bytesRead: Int = 0
        while (stream.read(buffer).also { bytesRead = it } >= 0) {
            out.write(buffer, 0, bytesRead)
        }
    }
    private fun sendEmail(context: Context, file:File) {
        val path =
            FileProvider.getUriForFile(
                context,
                BuildConfig.APPLICATION_ID + ".provider",
                file)
        val emailIntent: Intent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "message/rfc822"
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.etcv))
        emailIntent.putExtra(Intent.EXTRA_STREAM, path)
        emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        emailIntent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.checkout_cv))
        try {
            context.startActivity(Intent.createChooser(emailIntent, context.getString(R.string.select_app_to_send)))
        } catch (ex: ActivityNotFoundException) {

        }

    }
}