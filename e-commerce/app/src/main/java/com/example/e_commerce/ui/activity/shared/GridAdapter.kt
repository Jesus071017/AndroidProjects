package com.example.e_commerce.ui.activity.shared
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.e_commerce.R
import com.example.e_commerce.data.model.Product

class GridAdapter(private val context: Context, private val itemList: List<Product>) : BaseAdapter() {

    override fun getCount(): Int = itemList.size

    override fun getItem(position: Int): Any = itemList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val gridView: View

        if (convertView == null) {
            gridView = inflater.inflate(R.layout.grid_item, null)

            // Configurar la vista con los datos del elemento actual
            val imageView: ImageView = gridView.findViewById(R.id.product_image)
            val textView: TextView = gridView.findViewById(R.id.product_name)
            val value: TextView = gridView.findViewById(R.id.product_value)

            val currentItem = itemList[position]
            Glide.with(context)
                .load(currentItem.image)
                .into(imageView)
            textView.text = currentItem.name
            value.text = currentItem.value.toString()

        } else {
            gridView = convertView
        }

        return gridView
    }
}
