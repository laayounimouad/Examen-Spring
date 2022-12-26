package queries.client;

import lombok.Getter;

public class GetClientByIdQuery {
    @Getter private String id;

    public GetClientByIdQuery(String id) {
        this.id = id;
    }
}
