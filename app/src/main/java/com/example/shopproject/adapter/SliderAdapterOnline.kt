//package com.example.shopproject.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewpager2.widget.ViewPager2
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.resource.bitmap.CenterInside
//import com.bumptech.glide.request.RequestOptions
//import com.example.shopproject.Model.SliderModel
//import com.example.shopproject.R
//
//class SliderAdapter(
//    private var sliderImages: List<SliderModel>,
//    private val viewPager2: ViewPager2
//): RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
//
//    private lateinit var context: Context
//    private val runnable = Runnable{
//        sliderImages = sliderImages
//        notifyDataSetChanged()
//    }
//    class SliderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        private var imageView: ImageView = itemView.findViewById(R.id.imageSlide)
//
//        fun setItem(sliderItem: SliderModel, context: Context){
//            val requestOptions = RequestOptions().transform(CenterInside())
//            Glide.with(context)
//                .load(sliderItem.url)
//                .apply(requestOptions)
//                .into(imageView)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
//        context = parent.context
//        val view = LayoutInflater.from(context)
//            .inflate(R.layout.slider_item_container, parent, false)
//        return SliderViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return sliderImages.size
//    }
//
//    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
//        var item = sliderImages[position]
//        holder.setItem(item, context)
//    }
//}