package br.com.neppogamify.neppogamify.model;

/**
 * Created by joaop on 18/08/2017.
 */
public enum CargoFuncionario {
    CARGO1("Cargo1"),
    CARGO2("Cargo2"),
    Cargo3("Cargo3");

    private String descricao;

    CargoFuncionario(String descricao){
        this.descricao=descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
