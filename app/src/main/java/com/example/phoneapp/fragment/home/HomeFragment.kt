package com.example.phoneapp.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoneapp.R
import com.example.phoneapp.databinding.FragmentMainBinding
import com.example.phoneapp.room.PhoneNumber

class HomeFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val phoneAdapter = PhoneAdapter(PhoneNumber)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAction()
    }

    private fun initAction() {
        binding!!.fabAdd.setOnClickListener(::handlerOnClick)
    }

    private fun handlerOnClick(view: View?) {
        requireView().findNavController().navigate(R.id.addFragment)
    }

    private fun initView() {
        binding!!.apply {
            rcvList.layoutManager = LinearLayoutManager(requireContext())
            rcvList.adapter = phoneAdapter
        }
        initViewModel()
    }

    private fun initViewModel() {
        ViewModelProvider(this).get(PhoneViewModel::class.java)
            .getListData(requireContext()).observe(requireActivity()) {
                phoneAdapter.submitList(it)
            }
    }


}