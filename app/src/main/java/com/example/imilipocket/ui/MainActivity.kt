package com.example.imilipocket.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imilipocket.R
import com.example.imilipocket.model.Transaction
import com.example.imilipocket.ui.adapter.TransactionAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var rvTransactions: RecyclerView
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var fabAddTransaction: FloatingActionButton
    private val transactionList = ArrayList<Transaction>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTransactions = findViewById(R.id.Transactions)
        fabAddTransaction = findViewById(R.id.fabAddTransaction)

        // Setup RecyclerView
        transactionAdapter = TransactionAdapter(transactionList)
        rvTransactions.layoutManager = LinearLayoutManager(this)
        rvTransactions.adapter = transactionAdapter

        // Add new transaction button
        fabAddTransaction.setOnClickListener {
            val intent = Intent(this, AddTransactionActivity::class.java)
            startActivityForResult(intent, 100)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            val transaction = data.getSerializableExtra("transaction") as Transaction
            transactionList.add(transaction)
            transactionAdapter.notifyItemInserted(transactionList.size - 1)
            rvTransactions.scrollToPosition(transactionList.size - 1)
        }
    }
}
