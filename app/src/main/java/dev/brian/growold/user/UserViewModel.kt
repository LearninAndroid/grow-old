package dev.brian.growold.user

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import dev.brian.growold.BR
import dev.brian.growold.model.User
import java.util.*

class UserViewModel(private val user: User) : Observer, BaseObservable() {
    init {
        user.addObserver(this)
    }
    override fun update(o: Observable?, arg: Any?) {

        if (arg is String) {
            if (arg == "age") {
                notifyPropertyChanged(BR.age)
            } else if (arg == "firstName" || arg == "lastName") {
                notifyPropertyChanged(BR.name)
            } else if (arg == "imageUrl") {
                notifyPropertyChanged(BR.imageUrl)
            } else if (arg == "tagline") {
                notifyPropertyChanged(BR.tagline)
            } else if (arg == "female") {
                notifyPropertyChanged(BR.gender)
            }
        }
    }

    val name: String
        @Bindable get() {
            return user.firstName + " " + user.lastName
        }

    val age: String
        @Bindable get() {
            return if (user.age <= 0) return ""
            else String.format(Locale.ENGLISH, "%d years old", user.age)
        }

    val gender: String
        @Bindable get() {
            return if (user.female) return "Female" else "Male"
        }

    val imageUrl: String
        @Bindable get() {
            return user.imageUrl
        }

    val tagline: String
        @Bindable get() {
            return "Tagline: " + user.tagline
        }

    fun onButtonClick(view: View){
        this.user.age = 35
        this.user.imageUrl = "https://media.giphy.com/media/w7M8g9cTom0Du/giphy.gif"
        this.user.tagline = "Now he has grown up"
    }

}