package queries.category;

import lombok.Getter;

public class GetCategoryByIdQuery {
    @Getter
    private String id;

    public GetCategoryByIdQuery(String id) {
        this.id = id;
    }
}
