package events.client;


import commands.BaseCommand;
import events.BaseEvent;
import lombok.Getter;

public class ClientCreatedEvent extends BaseEvent<String> {
  @Getter private String nom;
    @Getter private String adresse;
    @Getter private String email;
    @Getter private String tele;

    public ClientCreatedEvent(String id, String nom, String adresse, String email, String tele) {
        super(id);
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.tele = tele;
    }
}
