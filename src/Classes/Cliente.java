//Classe que armazena os dados de Cliente
package Classes;


public class Cliente {
   
    //Atributos
    private String Nif;
    private String Nome;
    private String Telefone;
    private String Cidade;
    Conta conta[]= null;
    private int i;
    private int cant;
    
    //Construtores
    
    public Cliente(){
        
    }
    
    public Cliente(String Nif,String Nome,String Telefone,String Cidade){
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
    }
    
      public Cliente(String Nif,String Nome,String Telefone,String Cidade,int cant){
        this.Nif = Nif;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.cant = cant;
        conta = new Conta[cant];
    }
    
    //getters

    public String getNif() {
        return Nif;
    }

    public String getNome() {
        return Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public String getCidade() {
        return Cidade;
    }

    public int getI() {
        return i;
    }

    public int getCant() {
        return cant;
    }
    
    //Settres

    public void setNif(String Nif) {
        this.Nif = Nif;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setCant(int cont) {
        this.cant = cant;
    }
    
    //toString

    @Override
    public String toString() {
        return "Cliente{" + "Nif=" + Nif + ", Nome=" + Nome + ", Telefone=" + Telefone + ", Cidade=" + Cidade + ", i=" + i + ", cant=" + cant + '}';
    }
    
    //Preencher o vector de Contas
    
    public void inserirConta(int num, String tipo, int saldo){
        conta[i] = new Conta(num, tipo, saldo);
        i++;
        
    }

}
