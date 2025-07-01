package com.example.imilipocket.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.imilipocket.R
import com.example.imilipocket.model.Transaction
import com.example.imilipocket.model.TransactionType
import java.text.SimpleDateFormat
import java.util.*

class AddTransactionActivity : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var etAmount: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var tvDate: TextView
    private lateinit var radioGroupType: RadioGroup
    private lateinit var btnAdd: Button
    private var selectedDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        // Find Views
        etTitle = findViewById(R.id.etTitle)
        etAmount = findViewById(R.id.etAmount)
        spinnerCategory = findViewById(R.id.spinnerCategory)
        tvDate = findViewById(R.id.tvDate)
        radioGroupType = findViewById(R.id.radioGroupType)
        btnAdd = findViewById(R.id.btnAdd)

        // Set up categories
        val categories = arrayOf("Food", "Transport", "Entertainment", "Others")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        // Date Picker
        tvDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(this, { _, y, m, d ->
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                calendar.set(y, m, d)
                selectedDate = sdf.format(calendar.time)
                tvDate.text = selectedDate
            }, year, month, day)

            dialog.show()
        }

        // Add button
        btnAdd.setOnClickListener {
            val title = etTitle.text.toString()
            val amount = etAmount.text.toString().toDoubleOrNull()
            val category = spinnerCategory.selectedItem.toString()
            val type = when (radioGroupType.checkedRadioButtonId) {
                R.id.radioIncome -> TransactionType.INCOME
                R.id.radioExpense -> TransactionType.EXPENSE
                else -> return@setOnClickListener
            }

            if (title.isNotBlank() && amount != null && selectedDate.isNotBlank()) {
                val newTransaction = Transaction(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    amount = amount.toString(),
                    category = category,
                    date = selectedDate,
                    type = type
                )

                // Send back to MainActivity
                val resultIntent = Intent()
                resultIntent.putExtra("transaction", newTransaction)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
