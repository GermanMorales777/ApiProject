package com.apolis.animsearch.ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class CommonBinding {
    companion object {
        @JvmStatic
        @BindingAdapter("remote_source", "place_holder", requireAll = false)
        fun getImgFromRemoteSource(imageView: ImageView,
                                   url: String?,
                                   placeHolder: Drawable?) {
            url?.let{

                if(placeHolder == null){
                    Picasso.get().load(url).into(imageView)
                } else {
                    try {
                        Picasso.get()
                            .load(url)
                            .placeholder(placeHolder).into(imageView)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}