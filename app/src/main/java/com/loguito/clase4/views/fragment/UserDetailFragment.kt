package com.loguito.clase4.views.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.loguito.clase4.R

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {
    private val args: UserDetailFragmentArgs by navArgs()

    private lateinit var userNameTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userNameTextView = view.findViewById(R.id.textView)
        userNameTextView.text = args.user.email
    }
}