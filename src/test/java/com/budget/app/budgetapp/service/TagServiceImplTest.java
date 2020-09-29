package com.budget.app.budgetapp.service;

import com.budget.app.budgetapp.model.Tag;
import com.budget.app.budgetapp.repository.TagRepository;
import com.budget.app.budgetapp.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TagServiceImplTest {

  @InjectMocks
  private TagServiceImpl tagServiceImpl;

  @Mock
  private TagRepository tagRepository;

  private List<Tag> tagList;

  private String newTagName;

  private TestUtils testUtils;

  @BeforeEach
  void setUp()  {
    testUtils = new TestUtils();
    tagList = testUtils.generateTestTags(10, true);
    Tag generateTag = tagList.get(0);
    newTagName = generateTag.getName();
   Mockito.when(tagRepository.save(Mockito.any(Tag.class))).thenReturn(generateTag);
   Mockito.when(tagRepository.findAll()).thenReturn(tagList);
    Mockito.when(tagRepository.findByName(newTagName)).thenReturn(java.util.Arrays.asList(generateTag));
  }

  @Test
  void createTag() {
  Tag createTag = tagServiceImpl.createTag(newTagName);
  assertNotNull(createTag);
  assertEquals(createTag.getName(), newTagName);
  }

  @Test
  void getTagByName() {
   Tag retrievedTagByName =  tagServiceImpl.getTagByName(newTagName).get();
   assertEquals(retrievedTagByName.getName(), newTagName);
  }


  @Test
  void getAllTags() {
    List<Tag> allTags = tagServiceImpl.getAllTags().get();
    assertEquals(allTags.size(), tagList.size());
  }

  @Test
  void deleteTag() {
   Tag tag = tagServiceImpl.getAllTags().get().get(0);
   tagServiceImpl.deleteTag(tag.getId());
    Optional<Tag> tagWithShouldNotExist = tagRepository.findById(tag.getId());
    assertFalse(tagWithShouldNotExist.isPresent());
  }

}
