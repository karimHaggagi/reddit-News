package com.karimhaggagi.grandtask.presentation.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.karimhaggagi.grandtask.MainActivity
import com.karimhaggagi.grandtask.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)

        if (args.item.thumbnail_url.isNotEmpty()) {
            binding.imageView.visibility = View.VISIBLE
            val ratio = args.item.thumbnail_width / args.item.thumbnail_height

            val layoutParams = binding.imageView.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.dimensionRatio = ratio.toString()
            binding.imageView.layoutParams = layoutParams

        } else {
            binding.imageView.visibility = View.GONE
        }
        binding.model = args.item


        (requireActivity() as MainActivity).supportActionBar?.title = args.item.title
        return binding.root
    }

}