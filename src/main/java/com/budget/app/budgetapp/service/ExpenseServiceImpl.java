package com.budget.app.budgetapp.service;

import com.budget.app.budgetapp.model.Expense;
import com.budget.app.budgetapp.model.ExpensesBySearchCriteria;
import com.budget.app.budgetapp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpensesService {

    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Optional<List<Expense>> getExpensesBySearchCriteria(ExpensesBySearchCriteria criteria) {
        List<Expense> filteredExpenseList = new ArrayList<Expense>();
        List<Expense> allExpense = expenseRepository.findAll();

        if (criteria.getTagName() != null){
            filteredExpenseList = allExpense.stream()
                    .filter(expense -> expense.getTags().stream()
                    .anyMatch(tag -> criteria.getTagName().contains(tag.getName())))
                    .collect(Collectors.toList());

        }

        if (criteria.getFromData() != null){
            filteredExpenseList = filteredExpenseList.stream()
                    .filter(expense -> expense.getCreationData().isAfter(criteria.getFromData().toLocalDateTime()))
                    .collect(Collectors.toList());

        }

        if (criteria.getToData() != null){
            filteredExpenseList = filteredExpenseList.stream()
                    .filter(expense -> expense.getCreationData().isBefore(criteria.getToData().toLocalDateTime()))
                    .collect(Collectors.toList());

        }

        return Optional.of(filteredExpenseList);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);

    }

    @Override
    public Optional<List<Expense>> getAllExpenses() {
        return Optional.of( expenseRepository.findAll());
    }

    @Override
    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);

    }
}
