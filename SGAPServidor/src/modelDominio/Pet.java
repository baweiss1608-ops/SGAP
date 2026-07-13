
package modelDominio;

import java.io.Serializable;

//PASSO 1: IMPLEMENTS SERIALIZABLE
//PASSO 2: VARIÁVEIS
//PASSO 3: GETTERS E SETTERS
//PASSO 4: CONSTRUTORES DE ACORDO COM OS MODOS 
//PASSO 5: TO STRING

public class Pet implements Serializable{
    public static final long serialVersionUD = 123456789L;
    
    private int codPet;
    private String nomePet;
    private String especie;
    private String raca;
    private Usuario dono;
    private byte[] foto;

    public int getCodPet() {
        return codPet;
    }

    public void setCodPet(int codPet) {
        this.codPet = codPet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    //construtores
    
    //para selects e updates
    public Pet(int codPet, String nomePet, String especie, String raca, Usuario dono, byte[] foto) {
        this.codPet = codPet;
        this.nomePet = nomePet;
        this.especie = especie;
        this.raca = raca;
        this.dono = dono;
        this.foto = foto;
    }
       
    //para insert
    public Pet(String nomePet, String especie, String raca, Usuario dono, byte[] foto) {
        this.nomePet = nomePet;
        this.especie = especie;
        this.raca = raca;
        this.dono = dono;
        this.foto = foto;
    }
    
    //para delet
    public Pet(int codPet) {
        this.codPet = codPet;
    }

    @Override
    public String toString() {
        return "Pet{" + "codPet=" + codPet + ", nomePet=" + nomePet + ", especie=" + especie + ", raca=" + raca + ", dono=" + dono + ", foto=" + foto + '}';
    }
          
}
