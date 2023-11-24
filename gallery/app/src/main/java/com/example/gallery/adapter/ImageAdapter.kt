package com.example.gallery.adapter

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.gallery.DisplayImage

class ImageAdapter(private val context: Context, private val imagePaths: List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return imagePaths.size
    }

    override fun getItem(position: Int): Any {
        return imagePaths[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView

        if (convertView == null) {
            imageView = ImageView(context)
            imageView.layoutParams = ViewGroup.LayoutParams(350, 350)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }

        val imagePath = imagePaths[position]
        val bitmap = BitmapFactory.decodeFile(imagePath)
        imageView.setImageBitmap(bitmap)

        imageView.setOnClickListener {
            val intent = Intent(context, DisplayImage::class.java)
            intent.putExtra("image_path", imagePath)
            context.startActivity(intent)
        }

        return imageView
    }
}