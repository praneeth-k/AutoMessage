package com.example.automessage.service
//
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.telephony.TelephonyManager
//import android.widget.Toast
//
//
//class PhoneCallReceiver: BroadcastReceiver() {
//    override fun onReceive(context: Context?, intent: Intent?) {
//        val callState:String? = intent?.getStringExtra(TelephonyManager.EXTRA_STATE)
//        when {
////            callState?.equals(TelephonyManager.EXTRA_STATE_RINGING)!! ->{
////                Toast.makeText(context, "Ringing", Toast.LENGTH_SHORT).show()
////            }
//            callState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK) ->
//            {
//                val number: String? = intent?.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
//                Toast.makeText(context, "Received: $number", Toast.LENGTH_SHORT).show()
//            }
//            callState.equals(TelephonyManager.EXTRA_STATE_IDLE) -> Toast.makeText(context, "Idle", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
//
