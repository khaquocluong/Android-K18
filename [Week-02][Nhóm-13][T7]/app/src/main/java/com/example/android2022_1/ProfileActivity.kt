package com.example.android2022_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        showEditTextDialog()
    }
    private fun showEditTextDialog()
    {
        val textClick = findViewById<Button>(R.id.Edit_btn)
        val Name = findViewById<TextView>(R.id.editName)
        val Email = findViewById<TextView>(R.id.editEmail)
        val Phone = findViewById<TextView>(R.id.editPhone)
        textClick.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflarter = layoutInflater
            val dialogLayout =inflarter.inflate(R.layout.edit_text_layout, null)
            val editText_name = dialogLayout.findViewById<EditText>(R.id.et_editText_name)
            val editText_email = dialogLayout.findViewById<EditText>(R.id.et_editText_email)
            val editText_phone = dialogLayout.findViewById<EditText>(R.id.et_editText_phone)
            with(builder){
                setTitle("Nhập dữ liệu mới")
                setPositiveButton("Lưu lại"){dialog, which->
                    Name.text = editText_name.text.toString()
                    Email.text = editText_email.text.toString()
                    Phone.text = editText_phone.text.toString()
                }
                setNegativeButton("Hủy bỏ"){dialog, which->
                    Log.d("Main", "Negative Button Clicked")
                }
                setView(dialogLayout)
                show()
            }
        }
    }
}