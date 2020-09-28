package com.budget.app.budgetapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime creationData;

    private Double value;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "expenses_tag",
            joinColumns = {@JoinColumn(name = "expense_id", referencedColumnName = "id", nullable = false, updatable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false, updatable = false)})
    private List<Tag> tags;

    public Expense() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationData() {
        return creationData;
    }

    public void setCreationData(LocalDateTime creationData) {
        this.creationData = creationData;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
