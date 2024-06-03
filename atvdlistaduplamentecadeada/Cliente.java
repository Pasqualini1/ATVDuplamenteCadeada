
package br.vinicius.atvdlistaduplamentecadeada;

public class Cliente {
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String telefone;

    public Cliente(int codigo, String nome, String dataNascimento, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

   
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { 
        this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { 
        this.dataNascimento = dataNascimento; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { 
        this.telefone = telefone; }

    @Override
    public String toString() {
        return "Cliente: " +
                "\nCodigo = "  + codigo +
                "\nNome = " + nome +
                "\nData Nascimento = " + dataNascimento +
                "\nTelefone = " + telefone;
    }
}