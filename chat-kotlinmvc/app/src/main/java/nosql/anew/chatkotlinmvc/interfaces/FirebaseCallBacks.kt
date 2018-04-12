package nosql.anew.chatkotlinmvc.interfaces

import com.google.firebase.database.DataSnapshot

interface FirebaseCallBacks {
    fun onNewMessage(dataSnapshot: DataSnapshot?)
}