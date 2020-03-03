package guru.springframework.services;

import guru.springframework.api.v1.mapper.CategoryMapper;
import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

//without this class annotations mocks are not initialized
@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    public static final String NAME = "PEPPA";
    public static final Long ID = 1L;

    @Mock
    CategoryRepository categoryRepository;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @InjectMocks
    CategoryServiceImpl categoryService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void getAllCategories() {
        //given
        List<Category> results = new ArrayList<>();
        results.add(new Category());
        results.add(new Category());

        when(categoryRepository.findAll()).thenReturn(results);

        //when
         List<CategoryDTO> test = categoryService.getAllCategories();

        //then
        assertEquals(2,test.size());
    }

    @Test
    public void getCategoryByName() {
        //given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        //when
        CategoryDTO cat = new CategoryDTO();
        cat = categoryService.getCategoryByName(NAME);

        //then
        Assert.assertEquals(ID, cat.getId());
        assertEquals(NAME, cat.getName());
    }
}