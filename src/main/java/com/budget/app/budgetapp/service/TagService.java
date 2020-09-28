package com.budget.app.budgetapp.service;

import com.budget.app.budgetapp.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    public Optional<Tag> getTagByName(String tagName);

    public List<Optional<Tag>> getAllTags();

    public void deleteTag();

    public Tag createTag(String tagName);
}
