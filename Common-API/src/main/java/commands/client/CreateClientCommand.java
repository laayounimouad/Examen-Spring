package commands.client;


import commands.BaseCommand;
import lombok.Getter;

public class CreateClientCommand extends BaseCommand<String> {
  @Getter private String nom;
    @Getter private String adresse;
    @Getter private String email;
    @Getter private String tele;

    public CreateClientCommand(String id, String nom, String adresse, String email, String tele) {
        super(id);
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.tele = tele;
    }
}
