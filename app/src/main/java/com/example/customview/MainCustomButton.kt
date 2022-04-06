package com.example.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.customview.databinding.CustomButtonMainBinding

class MainCustomButton: ConstraintLayout {

    interface OnClickListener { fun onClick() }
    private lateinit var listener: OnClickListener

    private lateinit var binding: CustomButtonMainBinding
    private var bgActive: Int? = null
    private var bgInactive: Int? = null

    constructor(context: Context) : super(context){
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        init(context)
        getAttrs(attrs)
    }

    fun setOnClickListener(listener: OnClickListener) { this.listener = listener }

    private fun getAttrs(attrs:AttributeSet?){
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MainCustomButton)
        setTypeArray(typedArray)
    }

    private fun init(context :Context){
        binding = CustomButtonMainBinding.bind(LayoutInflater.from(context).inflate(R.layout.custom_button_main,this,false))
        addView(binding.root)

        binding.btnCustom.setOnClickListener { listener.onClick() }
    }

    private fun setTypeArray(typedArray : TypedArray){
        bgActive = typedArray.getResourceId(R.styleable.MainCustomButton_bgActive, R.drawable.edge_round_black)
        bgInactive = typedArray.getResourceId(R.styleable.MainCustomButton_bgInactive, R.drawable.edge_round_black)
        val isActive = typedArray.getBoolean(R.styleable.MainCustomButton_isActive, false)
        val bgDrawable = typedArray.getResourceId(R.styleable.MainCustomButton_bgDrawable, R.drawable.ic_check)
        val text = typedArray.getString(R.styleable.MainCustomButton_text)
        with(binding.btnCustom) {
            if (bgActive != null && bgInactive != null ){
                if (isActive) setBackgroundResource(bgActive!!)
                else setBackgroundResource(bgInactive!!)
            }
            setCompoundDrawablesWithIntrinsicBounds(0,0, bgDrawable, 0)
            this.text = text
        }
        typedArray.recycle()
    }

    fun setActive(isActive: Boolean) {
        with(binding.btnCustom) {
            if (bgActive != null && bgInactive != null ){
                if (isActive) setBackgroundResource(bgActive!!)
                else setBackgroundResource(bgInactive!!)
            }
        }
    }

}