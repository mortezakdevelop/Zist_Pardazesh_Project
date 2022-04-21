package com.example.zistpardazeshnasir.ui

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.zistpardazeshnasir.R
import com.example.zistpardazeshnasir.databinding.FragmentRegisterBinding
import java.nio.channels.SelectableChannel
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS


class RegisterFragment : Fragment() {

    lateinit var fragmentRegisterBinding: FragmentRegisterBinding
    var formatDatePicker = SimpleDateFormat("yyyy / MM / dd",Locale.US)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentRegisterBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_register, container, false)

        initDatePicker()

        fragmentRegisterBinding.btnConfirm.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_userAuthenticationFragment)
        }

        fragmentRegisterBinding.tvHaveAccount.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        return fragmentRegisterBinding.root
    }


    private fun initDatePicker() {
        fragmentRegisterBinding.tvBirthDay.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(requireContext(),android.R.style.Theme_Holo_Light_Dialog,DatePickerDialog.OnDateSetListener{datePcker,year,month,day ->

                val selectDate = Calendar.getInstance()
                selectDate.set(Calendar.YEAR,year)
                selectDate.set(Calendar.MONTH,month)
                selectDate.set(Calendar.DAY_OF_MONTH,day)
                val date = formatDatePicker.format(selectDate.time)
                Toast.makeText(requireContext(),"Date: " + date, Toast.LENGTH_LONG).show()
                fragmentRegisterBinding.tvBirthDay.text = date


            },getDate.get(Calendar.YEAR),getDate.get(Calendar.MONTH),getDate.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // when we are in home fragment and back pressed button , finish fragment
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        })
    }
}