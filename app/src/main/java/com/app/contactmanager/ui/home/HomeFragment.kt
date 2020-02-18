package com.app.contactmanager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.contactmanager.data.remote.response.ContactResponse
import com.app.contactmanager.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private val list = mutableListOf<ContactResponse.Contact>()
    private val contactsAdapter: ContactsAdapter by lazy {
        ContactsAdapter(list)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvContacts.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = contactsAdapter
        }

        homeViewModel.contacts.observe(this, Observer {
            list.clear()
            list.addAll(it)

            contactsAdapter.notifyDataSetChanged()
        })
    }
}