package com.example.sndapicall.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.sndapicall.R
import com.example.sndapicall.databinding.FragmentDogDetailBinding

class DogDetailFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentDogDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dogImage = requireArguments().getString("dogImageRes")
        binding.dogDetailImage.load(dogImage)

        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

    }


}