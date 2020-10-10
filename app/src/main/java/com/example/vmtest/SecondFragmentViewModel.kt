package com.example.vmtest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondFragmentViewModel : ViewModel(){

    val text = MutableLiveData<String>()

    fun setText(text: String) {
        this.text.value = text
    }

    init {
        Log.d(FirstActivity.LOG_TAG, "SF view model init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(FirstActivity.LOG_TAG, "SF view model cleared")
    }
}