package com.example.automessage

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    val REQUEST_CODE = 9009;
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val permissionTextView :TextView = requireView().findViewById(R.id.permission_message)

        if(isSMSPermissionGranted()) {
            permissionTextView.visibility = View.GONE
            view.findViewById<Button>(R.id.button_first)?.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
        else
            requestPermissions(
                Array(3) { android.Manifest.permission.RECEIVE_SMS; android.Manifest.permission.READ_SMS;  android.Manifest.permission.SEND_SMS},
                REQUEST_CODE
            )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(grantResults.isNotEmpty() && grantResults[1]==PackageManager.PERMISSION_GRANTED){
            view?.findViewById<Button>(R.id.button_first)?.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
        else if(!shouldShowRequestPermissionRationale(permissions[0]))
            showPermissionAlwaysDeniedAlertDialog()
        else
            showPermissionDeniedAlertDialog()
    }

    private fun showPermissionAlwaysDeniedAlertDialog()
    {
        val builder: AlertDialog.Builder? = activity?.let { android.app.AlertDialog.Builder(it) }!!
        if (builder != null) {
            builder.setMessage("App cannot function without the permissions. Please grant all requested permissions from settings application")
                .setTitle("Permissions Denied")
            val alertDialog: AlertDialog? = activity?.let {
                builder.apply {
                    setNegativeButton("Exit", DialogInterface.OnClickListener { dialog, id ->
                        System.exit(0);
                    })
                }
                builder.create()
            }
            alertDialog?.setCanceledOnTouchOutside(false)
            alertDialog?.show();
        }
    }

    private fun showPermissionDeniedAlertDialog()
    {
        val builder: AlertDialog.Builder? = activity?.let { android.app.AlertDialog.Builder(it) }!!
        if (builder != null) {
            builder.setMessage("App cannot function without the permissions. Please grant all requested permissions")
                .setTitle("Permissions Denied")
            val alertDialog: AlertDialog? = activity?.let {
                builder.apply {
                    setPositiveButton(
                        "Grant permission",
                        DialogInterface.OnClickListener { dialog, id ->
                            requestPermissions(
                                Array(3) { android.Manifest.permission.RECEIVE_SMS; android.Manifest.permission.READ_SMS;  android.Manifest.permission.SEND_SMS},
                                REQUEST_CODE
                            )
                        })
                    setNegativeButton("Exit", DialogInterface.OnClickListener { dialog, id ->
                        System.exit(0);
                    })
                }
                builder.create()
            }
            alertDialog?.setCanceledOnTouchOutside(false)
            alertDialog?.show();
        }
    }

    private fun isSMSPermissionGranted():Boolean{
        return ContextCompat.checkSelfPermission(this.requireContext(), android.Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED
    }
}