package com.budget.app.budgetapp.service;

import com.budget.app.budgetapp.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    public Optional<Tag> getTagByName(String tagName);

    public Optional<List<Tag>> getAllTags();

    public void deleteTag(Long tagId);

    public Tag createTag(String tagName);
}
