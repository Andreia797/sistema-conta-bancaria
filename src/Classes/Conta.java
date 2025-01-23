//Classe que ajuda o modelo a conter dados da conta do cliente

package Classes;


public class Conta {
    //Atributos
    private int num;
    private String tipo;
    private int saldo;
    
    //Construtores
    public Conta() {
    }

    public Conta(int num, String tipo, int saldo) {
        this.num = num;
        this.tipo = tipo;
        this.saldo = saldo;
    }
    
    //getters
     public int getNum() {
        return num;
    }

    public String getTipo() {
        return tipo;
    }

    public int getSaldo() {
        return saldo;
    }
    
    //Settrs
    public void setNum(int num) {
        this.num = num;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

//toString
    @Override
    public String toString() {
        return "Conta{" + "num=" + num + ", tipo=" + tipo + ", saldo=" + saldo + '}';
    }
    
    
}
