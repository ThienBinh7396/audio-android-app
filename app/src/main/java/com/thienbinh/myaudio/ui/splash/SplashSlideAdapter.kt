package com.thienbinh.myaudio.ui.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.thienbinh.myaudio.R
import com.thienbinh.myaudio.databinding.SplashRecycleLayoutBinding

class SplashSlideAdapter: RecyclerView.Adapter<SplashSlideAdapter.SplashSlideViewHolder>() {
  companion object{
    @BindingAdapter("bind:splashSlideAdapter")
    @JvmStatic
    fun bindSplashSlideAdapter(rcv: RecyclerView, list: MutableList<Int>?){
      if (rcv.adapter == null){
        rcv.adapter = SplashSlideAdapter()
        rcv.layoutManager = GridLayoutManager(rcv.context, 1, GridLayoutManager.HORIZONTAL, false)

        rcv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
          override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
              val offset = recyclerView.computeHorizontalScrollOffset()
              val extent = recyclerView.computeHorizontalScrollExtent()
              val range = recyclerView.computeHorizontalScrollRange()

              (rcv.adapter as SplashSlideAdapter).updateCurrentPositionAtPercentage { sizes ->
                offset / (range - extent) * sizes
              }
            }
          }
        })

        PagerSnapHelper().attachToRecyclerView(rcv)
      }

      list?.let {
        (rcv.adapter as SplashSlideAdapter).bindImages(it)
      }
    }
  }

  private val images = mutableListOf<Int>()
  private var currentPosition = 0

  class SplashSlideViewHolder(private val binding: SplashRecycleLayoutBinding): RecyclerView.ViewHolder(
    binding.root
  ){
    fun bindData(data: Int){
      binding.image = data
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SplashSlideViewHolder(
    DataBindingUtil.inflate(
      LayoutInflater.from(parent.context),
      R.layout.splash_recycle_layout,
      parent,
      false
    )
  )

  override fun onBindViewHolder(holder: SplashSlideViewHolder, position: Int) {
      holder.bindData(images[position])
  }

  override fun getItemCount(): Int = images.size

  fun updateCurrentPositionAtPercentage(calculateCurrentPosition: (sizes: Int) -> Int){
    currentPosition = calculateCurrentPosition(images.size)
  }

  fun getNextPosition() = if (currentPosition++ >= images.size) {
    currentPosition = 0
    0
  } else currentPosition

  fun bindImages(newList: List<Int>){
    val diffCallback = SplashSlideCallback(newList, images)
    val diffResult = DiffUtil.calculateDiff(diffCallback)
    images.clear()
    images.addAll(newList)

    diffResult.dispatchUpdatesTo(this)
  }

  class SplashSlideCallback(private val newList: List<Int>, private val oldList: List<Int>): DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
      oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
      oldList[oldItemPosition] == newList[newItemPosition]
  }
}