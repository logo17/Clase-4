package com.loguito.clase4.views.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.loguito.clase4.R
import com.loguito.clase4.views.adapters.UserHeaderAdapter
import com.loguito.clase4.views.adapters.UserListAdapter
import com.loguito.clase4.views.models.UserInformation

class UserListFragment : Fragment(R.layout.fragment_user_list) {
    private lateinit var userRecyclerView: RecyclerView

    // TODO 10: Declaramos el adapter de usuarios
    private val adapterH = UserListAdapter { userInformation ->
        val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(userInformation)
        findNavController().navigate(action)
    }

    private val adapterM = UserListAdapter { userInformation ->
        val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(userInformation)
        findNavController().navigate(action)
    }

    private val adapterP = UserListAdapter { userInformation ->
        val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(userInformation)
        findNavController().navigate(action)
    }

    private val concatAdapter = ConcatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        concatAdapter.addAdapter(UserHeaderAdapter("H"))
        concatAdapter.addAdapter(adapterH)
        concatAdapter.addAdapter(UserHeaderAdapter("M"))
        concatAdapter.addAdapter(adapterM)
        concatAdapter.addAdapter(UserHeaderAdapter("P"))
        concatAdapter.addAdapter(adapterP)

        adapterH.userList = getDummyUserListH()
        adapterM.userList = getDummyUserListM()
        adapterP.userList = getDummyUserListP()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO 11: Inflamos el recycler view y asignamos el adapter
        userRecyclerView = view.findViewById(R.id.userListRecyclerView)
        userRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))

        userRecyclerView.adapter = concatAdapter
    }

    private fun getDummyUserListH() : List<UserInformation> {
        return listOf(
            UserInformation("Heriberto Urena Madrigal", "hurena@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg"),
            UserInformation("Heriberto Urena Madrigal", "hurena@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg"),
            UserInformation("Heriberto Urena Madrigal", "hurena@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg")
        )
    }

    private fun getDummyUserListP() : List<UserInformation> {
        return listOf(
            UserInformation("Pedro Porras", "pporras@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg"),
            UserInformation("Pedro Porras", "pporras@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg")
        )
    }

    private fun getDummyUserListM() : List<UserInformation> {
        return listOf(
            UserInformation("Mariela Urena Madrigal", "mariela@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg"),
            UserInformation("Melissa Urena Madrigal", "melissa@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg"),
            UserInformation("Mariela Urena Madrigal", "mariela@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg"),
            UserInformation("Melissa Urena Madrigal", "melissa@mail.com", "https://auditconsulting.ec/cursos2020/wp-content/uploads/2014/10/speaker-3.jpg")
        )
    }
}