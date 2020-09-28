package com.budget.app.budgetapp.model;

import java.sql.Timestamp;
import java.util.List;

public class ExpensesBySearchCriteria {

    private Timestamp fromData;

    private  Timestamp toData;

    private List<String> tagName;

    public Timestamp getFromData() {
        return fromData;
    }

    public void setFromData(Timestamp fromData) {
        this.fromData = fromData;
    }

    public Timestamp getToData() {
        return toData;
    }

    public void setToData(Timestamp toData) {
        this.toData = toData;
    }

    public List<String> getTagName() {
        return tagName;
    }

    public void setTagName(List<String> tagName) {
        this.tagName = tagName;
    }
}
