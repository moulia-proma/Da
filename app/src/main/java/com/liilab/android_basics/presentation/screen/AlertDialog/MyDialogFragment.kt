package com.liilab.android_basics.presentation.screen.AlertDialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.liilab.android_basics.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyDialogFragment : DialogFragment() {

    private lateinit var cancelButton: ImageButton
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var titleDialog: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, android.R.style.Theme_NoTitleBar)
    }

    override fun getDialog(): Dialog? {
        return super.getDialog()
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window!!.setLayout(width, height)
        }
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = requireContext().let { Dialog(it) }
        dialog.setContentView(R.layout.myfragment_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        cancelButton = dialog.findViewById(R.id.cancel_alert)
        yesButton = dialog.findViewById(R.id.btn_yes)
        noButton = dialog.findViewById(R.id.btn_no)
        titleDialog = dialog.findViewById(R.id.text_alert_title)
        titleDialog.text = "I am a fulll Screen Dialog"

        cancelButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dismiss()
                Log.d("xyz", "cancel clicked")
                Toast.makeText(context, "Canceled", Toast.LENGTH_LONG).show()
            }

        })
        yesButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dismiss()
                if (context != null)
                    Toast.makeText(context, "Yes pressed", Toast.LENGTH_LONG).show()
            }

        })
        noButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dismiss()
                if (context != null)
                    Toast.makeText(context, "no pressed", Toast.LENGTH_LONG).show()
            }

        })




        return dialog
    }



//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflate the layout for this fragment
//        val rootView = inflater.inflate(R.layout.myfragment_dialog, container, true)
//
//        = rootView.findViewById(R.id.cancel_alert)
//
//        return rootView
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//
//
//    }

    companion object {
        const val TAG = "MyDialogFragment"
    }
}