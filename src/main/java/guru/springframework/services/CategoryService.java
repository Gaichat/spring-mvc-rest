package guru.springframework.services;

import guru.springframework.api.v1.model.CategoryDTO;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
