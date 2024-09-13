package com.example.shopproject.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.shopproject.Model.BrandModel
import com.example.shopproject.Model.SliderModel
import com.example.shopproject.ViewModel.BrandViewModel
import com.example.shopproject.ViewModel.MainViewModel
import com.example.shopproject.adapter.BrandAdapter
import com.example.shopproject.adapter.SliderAdapter
import com.example.shopproject.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity() {
    private val slideViewModel by inject<MainViewModel>()
    private val brandViewModel by inject<BrandViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initBanner()
        initBrand()
    }

    private fun initBrand() {
        binding.progressBarBrand.visibility = View.VISIBLE
        brandViewModel.brand.observe(this, Observer {
            items ->
                brands(items)
        })
        brandViewModel.loadBrand()
    }

    private fun brands(items: MutableList<BrandModel>) {
        binding.viewBrand.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

        binding.viewBrand.adapter = BrandAdapter(items)
        binding.progressBarBrand.visibility = View.GONE
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE
        slideViewModel.banners.observe(this, Observer {
            items ->
                banners(items)
                binding.progressBarBanner.visibility = View.GONE
        })
        slideViewModel.loadBanners()
    }

    private fun banners(images: List<SliderModel>){
        binding.viewpagerSlider.adapter = SliderAdapter(images, this)
        /*
        binding.viewpagerSlider.adapter = SliderAdapter(images, binding.viewpagerSlider)
        binding.viewpagerSlider.clipToPadding = false
        binding.viewpagerSlider.clipChildren = false
        binding.viewpagerSlider.offscreenPageLimit = 2
        binding.viewpagerSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
        }
        binding.viewpagerSlider.setPageTransformer(compositePageTransformer)
         */
        if(images.size > 1){
            binding.dots.visibility = View.VISIBLE
            binding.dots.attachTo(binding.viewpagerSlider)
        }
    }
}