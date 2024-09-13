package com.example.convidados.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.model.GuestModel
import com.example.convidados.R
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewmodel.GuestFormViewmodel

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
        val name = binndig.editName.text.toString()
            val presence = binndig.radioPresent.isChecked
            val model = GuestModel(0, name, presence)
            viewModel.insert(model)
        }
    }
}