package com.rdhd.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.rdhd.app.R
import kotlinx.android.synthetic.main.fragment_new_card_form.view.*
import android.content.Context.INPUT_METHOD_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.content.Context
import android.graphics.Color
import android.transition.TransitionManager
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doAfterTextChanged
import com.rdhd.app.utils.TextWatch
import kotlinx.android.synthetic.main.fragment_new_card_form.*
import kotlinx.android.synthetic.main.fragment_new_card_form.view.parentView


class NewCardFormFragment : Fragment() {

    companion object {
        val KEY_TITLE = "title"
        val KEY_VALUE = "value"
        val KEY_TYPE = "type"
        fun newInstance(title : String, value : String, type : String) : Fragment {
            val bundle = Bundle()
            bundle.putString(KEY_VALUE, value)
            bundle.putString(KEY_TITLE, title)
            bundle.putString(KEY_TYPE, type)
            val fragment = NewCardFormFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    lateinit var edittext : EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_card_form, container, false)
        view.title.text = arguments!!.getString(KEY_TITLE)
        view.value.hint = arguments!!.getString(KEY_VALUE)
        val type = arguments!!.getString(KEY_TYPE)
        view.value.setHintTextColor(Color.BLACK)
        view.value.doAfterTextChanged {
            if (!it.toString().isEmpty() && view.title.visibility == View.INVISIBLE) {
                TransitionManager.beginDelayedTransition(parentView)
                view.title.visibility = View.VISIBLE
            } else if (it.toString().isEmpty() && view.title.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(parentView)
                view.title.visibility = View.INVISIBLE
            }
            (activity as TextWatch)!!.emit(it.toString(), type)
        }
        edittext = view.value
        return view
    }


    override fun onResume() {
        super.onResume()
        edittext.setSelection(0)
        edittext.requestFocus()
    }
}