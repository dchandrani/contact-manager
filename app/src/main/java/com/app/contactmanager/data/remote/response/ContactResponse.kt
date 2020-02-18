package com.app.contactmanager.data.remote.response

data class ContactResponse(val results: List<Contact>) {

    data class Contact(val name: Name, val picture: Picture)

    data class Name(val first: String, val last: String) {
        val fullName: String
            get() = "$first $last"
    }

    data class Picture(val thumbnail: String)
}