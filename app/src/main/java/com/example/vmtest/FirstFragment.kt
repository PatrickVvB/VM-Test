package com.example.vmtest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

class FirstFragment : Fragment() {

    //если использовать activityViewModels() данные в vm будут  переживать переориентаци
    private val vm: FirstFragmentViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(FirstActivity.LOG_TAG, "FF attach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(FirstActivity.LOG_TAG, "FF create")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(FirstActivity.LOG_TAG, "FF create view")
        val view = inflater.inflate(R.layout.first_fragment, container, false)

        val text = view.findViewById<TextView>(R.id.tv_fragment)
        val field = view.findViewById<EditText>(R.id.et_fragment)
        val button = view.findViewById<Button>(R.id.btn_fragment)

        button.setOnClickListener {
            vm.setText(field.text.toString())
        }

        vm.text.observe(viewLifecycleOwner, {
            text.text = it
        })

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(FirstActivity.LOG_TAG, "FF destroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(FirstActivity.LOG_TAG, "FF destroy view")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(FirstActivity.LOG_TAG, "FF detach")
    }
}