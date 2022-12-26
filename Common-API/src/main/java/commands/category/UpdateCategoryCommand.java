package commands.category;

import commands.BaseCommand;
import lombok.Getter;

public class UpdateCategoryCommand extends BaseCommand<String> {
        @Getter
        private String nom;
        @Getter
        private String desc;

    public UpdateCategoryCommand(String id, String nom, String desc) {
        super(id);
        this.nom = nom;
        this.desc = desc;
    }
}
