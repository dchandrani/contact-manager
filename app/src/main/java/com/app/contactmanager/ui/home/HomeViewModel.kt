package com.app.contactmanager.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.contactmanager.data.RepositoryImpl
import com.app.contactmanager.data.remote.response.ContactResponse
import kotlinx.coroutines.launch

class HomeViewModel(private val repo: RepositoryImpl) : ViewModel() {
    private val _contacts = MutableLiveData<List<ContactResponse.Contact>>()
    val contacts: LiveData<List<ContactResponse.Contact>>
        get() = _contacts

    init {
        fetchContacts()
    }

    private fun fetchContacts() {
        viewModelScope.launch {
            _contacts.value = repo.fetchContacts()
        }
    }
}