package com.example.phoneapp.fragment.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.phoneapp.R
import com.example.phoneapp.databinding.FragmentAddBinding
import com.example.phoneapp.fragment.home.PhoneViewModel
import com.example.phoneapp.room.PhoneNumber

class AddFragment : Fragment() {

    private var binding : FragmentAddBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAction()
    }

    private fun initAction() {
        binding!!.apply {
            btnBack.setOnClickListener(::handlerClickBackButton)
            btnAdd.setOnClickListener(::handlerClickAddButton)
        }
    }

    private fun handlerClickAddButton(view: View?) {
        val strName = binding!!.edtName.text.toString().trim()
        val strPN = binding!!.edtPhoneNumber.text.toString().trim()
        if (!TextUtils.isEmpty(strName) && !TextUtils.isEmpty(strPN)){
            if (strPN.length == 10){
                ViewModelProvider(this).get(PhoneViewModel::class.java)
                    .addToList(PhoneNumber(1, strName, strPN), requireContext())
                handlerClickBackButton(view)
            }
        } else {
            Toast.makeText(requireContext(), "Blank", Toast.LENGTH_LONG).show()
        }
    }

    private fun handlerClickBackButton(view: View?) {
        requireView().findNavController().navigate(R.id.homeFragment)
    }

    private fun initView() {
        binding!!.apply {

        }
        initViewModel()
    }

    private fun initViewModel() {
//        ViewModelProvider(this).get(PhoneViewModel::class.java)
    }
}

