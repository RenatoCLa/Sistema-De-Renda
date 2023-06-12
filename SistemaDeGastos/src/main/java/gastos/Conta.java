package gastos;
public class Conta{

    protected String nomeUser;
    protected String senhaUser;

     public Conta(String nome , String senha){
         this.nomeUser = nome;
         this.senhaUser = senha;
    }

    public String getNome(){
        return this.nomeUser;
    }

    public void setNome(String nome){
        this.nomeUser = nome;
    }

    public String getSenha(){
        return this.senhaUser;
    }

    public void setSenha(String senha){
        this.senhaUser = senha;
    }
}