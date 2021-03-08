package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtLength: EditText
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Activity
        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }

        // Intent
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        // Views and ViewGroup
        val btnViewActivity: Button = findViewById(R.id.btn_view_activity)
        btnViewActivity.setOnClickListener(this)

        // Recycler View
        val btnRecyclerActivity: Button = findViewById(R.id.btn_recycler_activity)
        btnRecyclerActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_calculate -> {
                if (v?.id == R.id.btn_calculate) {
                    val inputLength = edtLength.text.toString().trim()
                    val inputWidth = edtWidth.text.toString().trim()
                    val inputHeight = edtHeight.text.toString().trim()

                    var isEmptyFields = false

                    when {
                        inputLength.isEmpty() -> {
                            isEmptyFields = true
                            edtLength.error = "Field ini tidak boleh kosong"
                        }
                        inputWidth.isEmpty() -> {
                            isEmptyFields = true
                            edtWidth.error = "Field ini tidak boleh kosong"
                        }
                        inputHeight.isEmpty() -> {
                            isEmptyFields = true
                            edtHeight.error = "Field ini tidak boleh kosong"
                        }
                    }

                    if (!isEmptyFields) {
                        val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                        tvResult.text = volume.toString()
                    }
                }
            }
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_view_activity -> {
                val moveIntent = Intent(this@MainActivity, ViewActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_recycler_activity -> {
                val moveIntent = Intent(this@MainActivity, RecyclerActivity::class.java)
                startActivity(moveIntent)
            }
        }

    }
}