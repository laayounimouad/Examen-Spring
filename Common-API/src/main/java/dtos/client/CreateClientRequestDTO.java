package dtos.client;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientRequestDTO {
    private String nom;
    private String adresse;
    private String email;
    private String tele;
}
