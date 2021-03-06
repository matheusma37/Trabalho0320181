package pooa20181.iff.edu.trabalho03_2018_1.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Oficina extends RealmObject implements Serializable{
    private String nome, rua, bairro, municipio;
    private int longitude, latitude;
    @PrimaryKey
    private int id;

    public Oficina(){}

    public Oficina(String nome, String rua, String bairro,
                   String municipio, int longitude, int latitude, int id) {
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.municipio = municipio;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
