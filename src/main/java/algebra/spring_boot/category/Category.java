package algebra.spring_boot.category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer id;

    private String name;

    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
