package com.example.automessage

import android.os.Bundle
import android.telephony.SmsManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainFragment : Fragment() {

    var serviceSwitch: SwitchCompat?=null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferences: Preferences = Preferences(this.requireContext(), "AutoMsgPref.xml")
        serviceSwitch = view.findViewById(R.id.enableAutoReplyServiceSwitch)
        serviceSwitch?.isChecked = preferences.getServiceEnableFlagValue()

        serviceSwitch?.setOnClickListener {
            preferences.updatePreferences(serviceSwitch?.isChecked.toString())
        }

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            val smsManager :SmsManager = SmsManager.getDefault()
            try {
                smsManager.sendTextMessage("8310158828", "7411752707", "Hello, this is a sample message sent from autoMessage", null, null)
                Toast.makeText(context, "Message sent", Toast.LENGTH_SHORT).show()
            }
            catch (t: Throwable){
                Toast.makeText(context, "error sending message", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<Button>(R.id.filters_button).setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_FiltersFragment)
        }
    }
}