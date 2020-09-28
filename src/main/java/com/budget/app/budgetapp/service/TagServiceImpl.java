package com.budget.app.budgetapp.service;

import com.budget.app.budgetapp.model.Tag;
import com.budget.app.budgetapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Optional<Tag> getTagByName(String tagName) {
        Tag foundTag = null;
      List<Tag> foundByName =  tagRepository.findByName(tagName);
      if (foundByName.size() > 0){
          foundTag = foundByName.get(0);
      }
      return Optional.of(foundTag);
    }

    @Override
    public Optional<List<Tag>> getAllTags() {
        List<Tag> allTags = tagRepository.findAll();
        return Optional.of(allTags);
    }

    @Override
    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }


    @Override
    public Tag createTag(String tagName) {
        return tagRepository.save(new Tag(tagName));

    }
}
