package events.category;


import events.BaseEvent;
import lombok.Getter;

public class CategoryUpdatedEvent extends BaseEvent<String> {
    @Getter
    private String nom;
    @Getter
    private String desc;

    public CategoryUpdatedEvent(String id, String nom, String desc) {
        super(id);
        this.nom = nom;
        this.desc = desc;
    }
}
