package com.example.alkyedemo.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.alkyedemo.R
import com.example.alkyedemo.databinding.ActivityHomeBinding
import com.example.alkyedemo.databinding.ActivityMainBinding
import com.example.alkyedemo.model.Item
import com.example.alkyedemo.ui.adapter.FeaturedArticleAdapter
import com.example.alkyedemo.ui.adapter.RecentArticleAdapter
import com.example.alkyedemo.ui.adapter.SocialConnectItemAdapter
import com.example.alkyedemo.utils.launchActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        bindRecyclerView()
    }

    private fun bindRecyclerView() {
        // Static dummy data
        val dummyData = listOf(
            Item(getString(R.string.step_into_tomorrow), getString(R.string.date)),
            Item(getString(R.string.step_into_tomorrow), getString(R.string.date)),
            Item(getString(R.string.step_into_tomorrow), getString(R.string.date)),
            Item(getString(R.string.step_into_tomorrow), getString(R.string.date)),
        )

        val socialList = listOf(
            Item(getString(R.string.social_connect_item_description), getString(R.string.date)),
            Item(getString(R.string.social_connect_item_description), getString(R.string.date)),
            Item(getString(R.string.social_connect_item_description), getString(R.string.date)),
            Item(getString(R.string.social_connect_item_description), getString(R.string.date)),
        )

        binding.rvFeaturedArticle.adapter = FeaturedArticleAdapter(dummyData, onClick = { launchActivity<DetailActivity>() })
        binding.rvRecentArticles.adapter = RecentArticleAdapter(dummyData, onClick = { launchActivity<DetailActivity>() })
        binding.socialConnectLayout.rvSocialConnect.adapter = SocialConnectItemAdapter(socialList, onClick = { launchActivity<DetailActivity>() })
    }
}