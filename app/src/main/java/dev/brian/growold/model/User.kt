package dev.brian.growold.model

import java.util.*

class User : Observable() {
    var firstName: String = ""
        set(value) {
            field = value
            setChangedAndNotify("firstName")
        }

    var lastName: String = ""
        set(value) {
            field = value
            setChangedAndNotify("lastName")
        }

    var age: Int = 0
        set(value) {
            field = value
            setChangedAndNotify("age")
        }
    var imageUrl: String = ""
        set(value) {
            field = value
            setChangedAndNotify("imageUrl")
        }

    var tagline: String = ""
        set(value) {
            field = value
            setChangedAndNotify("tagline")
        }

    var female : Boolean = false
    set(value){
        field = value
        setChangedAndNotify("female")
    }

    private fun setChangedAndNotify(field: Any) {
        setChanged()
        notifyObservers(field)
    }
}