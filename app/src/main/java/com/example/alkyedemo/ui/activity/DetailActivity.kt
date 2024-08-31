package com.example.alkyedemo.ui.activity

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.alkyedemo.R
import com.example.alkyedemo.databinding.ActivityDetailBinding
import com.example.alkyedemo.databinding.ActivityHomeBinding
import com.example.alkyedemo.model.Item
import com.example.alkyedemo.ui.adapter.FeaturedArticleAdapter
import com.example.alkyedemo.ui.adapter.RecentArticleAdapter
import com.example.alkyedemo.utils.launchActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.clickHandler = this

        bindRecyclerView()

        val spannableString = SpannableString(getString(R.string.long_description))

        spannableString.setSpan(RelativeSizeSpan(2.0f), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.longDescription.text = spannableString
    }

    private fun bindRecyclerView() {
        // Static dummy data
        val dummyData = listOf(
            Item(getString(R.string.step_into_tomorrow), getString(R.string.date)),
            Item(getString(R.string.step_into_tomorrow), getString(R.string.date)),
            Item(getString(R.string.step_into_tomorrow), getString(R.string.date)),
            Item(getString(R.string.step_into_tomorrow), getString(R.string.date)),
        )

        binding.rvFeaturedArticle.adapter = FeaturedArticleAdapter(dummyData, onClick = { launchActivity<DetailActivity>() })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgBack -> {
                finish()
            }
        }
    }
}