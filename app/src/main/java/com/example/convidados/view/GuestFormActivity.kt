package com.example.convidados.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.model.GuestModel
import com.example.convidados.R
import com.example.convidados.constanrs.DataBaseConstants
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewmodel.GuestFormViewmodel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binndig: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewmodel
    private var guestId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binndig = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binndig.root)
        viewModel = ViewModelProvider(this).get(GuestFormViewmodel::class.java)
        binndig.buttonConfirmation.setOnClickListener(this)
        binndig.radioPresent.isChecked = true
        observe()
        loadData()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_confirmation) {
            val name = binndig.editName.text.toString()
            val presence = binndig.radioPresent.isChecked
            val model = GuestModel(guestId, name, presence)
            viewModel.save(model)
            finish()
        }
    }

    private fun observe() {
        viewModel.guest.observe(this, Observer {
            binndig.editName.setText(it.name)
            if (it.presence) {
                binndig.radioPresent.isChecked = true
            } else {
                binndig.radioAbsent.isChecked = true
            }
        })
        viewModel.saveGuest.observe(this, Observer {
            if (it != "") {
                if (guestId == 0) {
                    Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        })
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }
    }


}