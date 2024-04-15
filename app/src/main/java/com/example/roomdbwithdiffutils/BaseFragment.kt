package com.example.roomdbwithdiffutils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes private val layoutId: Int)  : Fragment() {

    private var rootView: View? = null
    private var isVIewCreatedOneTime2:Boolean?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (rootView == null){
            rootView = inflater.inflate(layoutId, container, false);
        }else{
            (rootView?.parent as ViewGroup).removeView(rootView)
        }
        return rootView as View
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isVIewCreatedOneTime2 == false){
            isVIewCreatedOneTime2 = true
            onOneTimeCreated()
        }
        onCreateEveryTime()
    }

    abstract fun onOneTimeCreated()
    abstract fun onCreateEveryTime()
}