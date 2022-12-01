package com.karimhaggagi.grandtask.presentation.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.karimhaggagi.grandtask.R
import java.util.*

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {

    Glide.with(imageView.context)
        .load(url)
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(imageView)

}