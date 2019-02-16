package dev.brian.growold

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dev.brian.growold.model.User
import dev.brian.growold.user.UserViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = User()
        user.age = 20;
        user.female = false
        user.firstName = "Johnny"
        user.lastName = "Depp"
        user.imageUrl = "https://media.giphy.com/media/zv8PVZLXBj81a/giphy.gif"
        user.tagline = "When Johhny Depp is Young"

        val userViewModel = UserViewModel(user)
        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this,R.layout.activity_main)
        binding.setVariable(BR.user,userViewModel)
    }
}
