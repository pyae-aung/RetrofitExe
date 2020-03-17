package com.example.retrofitexe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitexe.R.id.txtFactTitle
import kotlinx.android.synthetic.main.activity_fact.*
import kotlinx.android.synthetic.main.item_fact.*

class FactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact)

        txtFactTitle.text = intent.getStringExtra("TITLE")
//        txtFactBody.text = intent.getStringExtra("BODY")
    }
}
