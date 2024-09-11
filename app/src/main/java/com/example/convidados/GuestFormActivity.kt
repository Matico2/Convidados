package com.example.convidados

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binndig: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binndig =  ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binndig.root)
        viewModel = ViewModelProvider(this).get(GuestFormViewmodel::class.java)
        binndig.buttonConfirmation.setOnClickListener(this)
        binndig.radioPresent.isChecked = true

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_confirmation){

        }
    }
}