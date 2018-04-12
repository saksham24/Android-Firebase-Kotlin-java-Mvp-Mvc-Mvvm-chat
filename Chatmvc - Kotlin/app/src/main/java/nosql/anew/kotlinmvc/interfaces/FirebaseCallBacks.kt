package nosql.anew.kotlinmvc.interfaces

import com.google.firebase.database.DataSnapshot

interface FirebaseCallBacks {
    fun onNewMessage(dataSnapshot: DataSnapshot?)
}