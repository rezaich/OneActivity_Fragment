package com.zaich.flexiblefragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_option_dialog.*

class OptionDialogFragment : DialogFragment() {
    private var optionDialogListener :OnOptionDialogListener? =  null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_choose.setOnClickListener {
            val checkedRadioButtonId = rg_options.checkedRadioButtonId
            if(checkedRadioButtonId != -1){
                var game : String? = null
                when(checkedRadioButtonId){
                    R.id.rb_pubg -> game = rb_pubg.text.toString().trim()
                    R.id.rb_ff -> game = rb_ff.text.toString().trim()
                    R.id.rb_sm -> game = rb_sm.text.toString().trim()
                }
                optionDialogListener?.onOptionChosen(game)
                dialog?.dismiss()
            }
        }
        btn_close.setOnClickListener {
            dialog?.cancel()
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }
    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }


}