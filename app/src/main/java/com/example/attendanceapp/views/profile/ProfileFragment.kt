package com.example.attendanceapp.views.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.attendanceapp.PrefManager
import com.example.attendanceapp.R
import com.example.attendanceapp.databinding.FragmentProfileBinding
import com.example.attendanceapp.views.changepass.ChangePasswordActivity
import com.example.attendanceapp.views.login.LoginActivity
import com.example.attendanceapp.views.main.MainActivity
import com.example.attendanceapp.views.salary.SalaryActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ProfileFragment : Fragment() {
    private val pref by lazy { context?.let { PrefManager(it) } }
    private var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        binding?.btnChangePassword?.setOnClickListener {
            context?.startActivity<ChangePasswordActivity>()
        }

       binding?.btnLihatGaji?.setOnClickListener {
            context?.startActivity<SalaryActivity>()
        }

        binding?.btnLogout?.setOnClickListener {
            pref!!.removeSP()
            context?.startActivity<LoginActivity>()
            (activity as MainActivity).finishAffinity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}