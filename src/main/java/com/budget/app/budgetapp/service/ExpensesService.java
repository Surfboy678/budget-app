package com.budget.app.budgetapp.service;

import com.budget.app.budgetapp.model.Expense;
import com.budget.app.budgetapp.model.ExpensesBySearchCriteria;

import java.util.List;
import java.util.Optional;

public interface ExpensesService {

    public Optional<List<Expense>> getExpensesBySearchCriteria(ExpensesBySearchCriteria criteria);

    public Expense createExpense(Expense expense);

    public Optional<List<Expense>> getAllExpenses();

    public void deleteExpense(Long expenseId);
}
