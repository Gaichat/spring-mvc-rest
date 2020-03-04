package guru.springframework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryListDTO {
    //categories will be the name of the mapping in the json file
    private List<CategoryDTO> categories;
}
