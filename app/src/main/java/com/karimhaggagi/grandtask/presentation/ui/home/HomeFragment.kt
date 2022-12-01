package com.karimhaggagi.grandtask.presentation.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.karimhaggagi.grandtask.data.data_source.local.DatabaseNews
import com.karimhaggagi.grandtask.databinding.FragmentHomeBinding
import com.karimhaggagi.grandtask.presentation.ui.home.adapter.NewsListAdapter
import com.karimhaggagi.grandtask.presentation.utils.UiState
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: NewsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)

        observeData()
        return binding.root
    }

    private fun observeData() {
        lifecycleScope.launchWhenResumed {
            viewModel.newsLisStateFlow.collectLatest { newsResponse ->
                handleNewsResponse(newsResponse)
            }
        }

        lifecycleScope.launchWhenResumed {
            viewModel.networkStateFlow.collectLatest { networkResponse ->
                when (networkResponse) {
                    is UiState.Empty -> {}
                    is UiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is UiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                    }
                    is UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Log.i("@@##error", networkResponse.error)
                    }
                }
            }
        }
    }

    private fun handleNewsResponse(data: List<DatabaseNews>) {
        binding.rvNews.adapter = NewsListAdapter(onNewsItemClick = { item ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                    item
                )
            )
        }).apply {
            submitList(data)
        }
    }
}