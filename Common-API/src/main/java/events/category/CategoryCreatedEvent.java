package events.category;


import enums.Etat;
import events.BaseEvent;
import lombok.Getter;

public class CategoryCreatedEvent extends BaseEvent<String> {
    @Getter
    private String nom;
    @Getter
    private String desc;

    public CategoryCreatedEvent(String id, String nom, String desc) {
        super(id);
        this.nom = nom;
        this.desc = desc;
    }
}
