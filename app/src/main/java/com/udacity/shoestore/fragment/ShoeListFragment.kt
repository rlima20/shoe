package com.udacity.shoestore.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.viewModel.ShoeViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
    }

    @SuppressLint("SetTextI18n")
    private fun setupObservers() {
        viewModel.listOfShoes.observe(viewLifecycleOwner, Observer { listOfShoes ->
            if (listOfShoes.size > 0) {
                listOfShoes.forEach { shoe ->
                    binding.nameTextView.text.let {
                        binding.nameTextView.text = shoe.name + "\n" + it
                    }
                }
            }
        })
    }

    private fun setupListeners() {
        binding.fabNewShoe.setOnClickListener {
            findNavController().navigate(
                ShoeListFragmentDirections
                    .actionShoeListFragmentToShoeDetailFragment()
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.loginFragment -> {
                viewModel.onLogout()
                findNavController().navigate(
                    ShoeListFragmentDirections
                        .actionShoeListFragmentToLoginFragment()
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}