package com.example.sunapp.utils

import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.recyclerview.widget.RecyclerView

class CustomLayoutManager: RecyclerView.LayoutManager() {
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        super.onLayoutChildren(recycler, state)
    }

    override fun canScrollHorizontally(): Boolean {
        return super.canScrollHorizontally()
    }

    override fun canScrollVertically(): Boolean {
        return super.canScrollVertically()
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        return super.scrollHorizontallyBy(dx, recycler, state)
    }

    override fun scrollVerticallyBy(dy: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        return super.scrollVerticallyBy(dy, recycler, state)
    }

    override fun detachAndScrapAttachedViews(recycler: RecyclerView.Recycler) {
        super.detachAndScrapAttachedViews(recycler)

    }

    override fun layoutDecoratedWithMargins(child: View, left: Int, top: Int, right: Int, bottom: Int) {
        super.layoutDecoratedWithMargins(child, left, top, right, bottom)

    }

    override fun supportsPredictiveItemAnimations(): Boolean {
        return super.supportsPredictiveItemAnimations()
    }
}