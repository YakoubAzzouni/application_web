package com.Koubi.parking.Modele;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Adress {
    private final UUID adress_id;
    private String Rue;
    private int code;
    private String ville;
    private String pays;

    public Adress(UUID adress_id,
                  @JsonProperty("rue") String rue,
                  @JsonProperty("code") int code,
                  @JsonProperty("ville") String ville,
                  @JsonProperty("pays") String pays) {
        this.adress_id = adress_id;
        Rue = rue;
        this.code = code;
        this.ville = ville;
        this.pays = pays;
    }

    public String getRue() {
        return Rue;
    }

    public void setRue(String rue) {
        Rue = rue;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public UUID getAdress_id() {
        return adress_id;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "adress_id=" + adress_id +
                ", Rue='" + Rue + '\'' +
                ", code=" + code +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
