package com.example.imilipocket.data

import com.example.imilipocket.model.Transaction

class TransactionRepository {
    private val transactionList = mutableListOf<Transaction>()

    fun addTransaction(transaction: Transaction) {
        transactionList.add(transaction)
    }

    fun getAllTransactions(): List<Transaction> {
        return transactionList
    }

    fun deleteTransaction(transaction: Transaction) {
        transactionList.remove(transaction)
    }

    fun clearAll() {
        transactionList.clear()
    }
}
