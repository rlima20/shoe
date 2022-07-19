package com.udacity.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewModel.ShoeViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            if (onValidateFields()) {
                viewModel.onLogin()
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }

        binding.btnNewAccount.setOnClickListener {
            //findNavController().navigate(LoginFragmentDirections
            //.actionLoginFragmentToWelcomeFragment())
        }
    }

    private fun onValidateFields(): Boolean {
        var validated = true
            if (binding.editTextEmail.text.isEmpty()) {
                binding.editTextEmail.error = "*"
                validated = false
            }
            if (binding.editTextPassword.text.isEmpty()) {
                binding.editTextPassword.error = "*"
                validated = false
            }
        return validated
    }
}