package com.example.vmtest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstFragmentViewModel : ViewModel() {

    val text = MutableLiveData<String>()

    fun setText(text: String) {
        this.text.value = text
    }

    init {
        Log.d(FirstActivity.LOG_TAG, "FF view model init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(FirstActivity.LOG_TAG, "FF view model cleared")
    }
}