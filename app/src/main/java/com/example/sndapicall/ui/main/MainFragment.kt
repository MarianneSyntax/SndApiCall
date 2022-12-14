package com.example.sndapicall.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sndapicall.R
import com.example.sndapicall.adapter.DogAdapter
import com.example.sndapicall.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dogAdapter = DogAdapter()
        binding.dogRecycler.adapter = dogAdapter

        viewModel.dogs.observe(viewLifecycleOwner){
            dogAdapter.submitList(it)
        }

        viewModel.loading.observe(viewLifecycleOwner){
            when(it){
                ApiStatus.LOADING -> {
                    binding.progressSpinner.visibility = View.VISIBLE
                }
                ApiStatus.DONE -> {
                    binding.progressSpinner.visibility = View.INVISIBLE
                }
                ApiStatus.ERROR -> {
                    binding.progressSpinner.visibility = View.GONE
                }
            }
        }

        binding.searchBtn.setOnClickListener {
            val term = binding.homeSearchEdit.text.toString()
            if (term != "") {
                viewModel.search(term)
            } else {
                Toast.makeText(requireContext(), "invalid search", Toast.LENGTH_SHORT).show()
            }
        }

    }

}