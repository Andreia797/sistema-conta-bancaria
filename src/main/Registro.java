//Classe que administra processos do modelo de colaboracao vetorial

/**
 * Metodos Implimentados em classe Registro:
 * 
 * 1-Metudo de Inserir Cliente
 * 2-Metudo de Editar Cliente
 * 3-Metudo para Eliminar Registro
 * 4-Metudo para Modificar Cliente 
 * 5-Metudo para Modificar Conta
 * 6-Metudo para Buscar Conta 
 * 7-Metudo para Buscar Cliente
 * 8-Metudo para Tranzações --> "Gerencia e Deposito"
 * 9-Metudo para Buscar Cliente 
 */


package main;


import Classes.Cliente;

import classes.*; //Importamos todas as classes com -->(*)
import static main.Registro.cliente;

public class Registro {
    
    //Arranjo
    static Cliente cliente[] = null;
    
    //Contador
    static int cont = 0;
    
    //psvm Menu Principal
    public static void main(String[] args){
        cliente = new Cliente[3]; // Arranjo de comprimento 5
        int cant = 0;
        int op = 0; //Variavel de opcao
        
        //Menu principal
        
        do{
            System.out.println("\n\n\n-- MENU PRINCIPAL --");
            System.out.println("---------------------------");
            System.out.println("1- Inserir Cliente");
            System.out.println("2- Editar Cliente");
            System.out.println("3- Tranzacoes");// Ordena o deposito
            System.out.println("4- Listar Clientes");
            System.out.println("5- Sair");
            
            System.out.print("Escolhe uma opcao: ");
            op = Ler.dadoInt(); // aque vai ler 
            
            switch(op) {
                case 1:
                    inserirCliente();// metudo para registrar clientes
                    break;
                case 2 :
                    editarCliente();
                case 3:
                    tranzacoes();
                case 4 :
                    listarClientes();
                case 5 :
                    System.out.println(" Saindo ... ");
                default:
                    System.out.println("Opcao inválida! ");;
            }
        }while (op != 5);{
        System.exit(0);
    }
        //Metudo para incerir Clientes
        
        
           
        }

         //1-Metudo de Inserir Cliente
        private static void inserirCliente(){
            
            //Variavel local
            String Nif;
            String Nome;
            String Telefone;
            String Cidade;
            String Tipo;
            int num = 0;
            int saldo = 0;
            int cant = 0;
            
            //Menu de controlo
             System.out.println("\n\n\n-- DADOS DO CLIENTE --");
             System.out.println("-----------------------------");
             
             
           System.out.print("Nif: ");
           Nif = Ler.dado();
           System.out.print("Nome: ");
           Nome = Ler.dado();
           System.out.print("Telefone: ");
           Telefone = Ler.dado();
           System.out.print("Cidade: ");
           Cidade = Ler.dado();
           System.out.print("Valor da conta: ");
           cant = Ler.dadoInt();
           
           //
           cliente[cont] = new Cliente(Nif, Nome, Telefone, Cidade, cant);
           for(int i = 0; i < cont ; i++){
             System.out.println("\n\n\n-- DADOS DA CONTA --");
             System.out.println("-----------------------------");
             System.out.print("Número da Conta:");
             num = Ler.dadoInt();
             System.out.print("Tipo de Conta: ");
             Tipo = Ler.dado();
             System.out.print("Saldo: ");
             saldo = Ler.dadoInt();
             
             
             cliente[cont].inserirConta(num, Tipo, saldo);           
           }
           cont++;
           System.out.println("Cliente e Conta armasenada com sucesso! " + cont); //Mensagem de confirmacao
           
        }
        
        //2-Metudo de Editar Cliente
        private static void editarCliente(){
            String Nif = null;
            int acao = 0;
            int pos = -1;
            int cant = 0;
            
            //Mensagem de solicitacao
            System.out.print("\n\nIncira o Nif para a procura:   ");
            Nif = Ler.dado();
            pos = buscarCliente(Nif); 
            
            if(pos >= 0){
                System.out.println("\n\nRegistro encontrado!");
                System.out.println("\n\n\n" + cliente[pos].toString());
                cant = cliente[pos].getCant(); 
                
                for(int i = 0; i < cant; i++){
                    cliente[pos].getConta()[i].toString();  
            }

            //Menu de Controle
            System.out.println("\n\n\n-- MENU DE MODIFICACAO -- ");
            System.out.println("1.-Actualizar Cliente");
            System.out.println("2.-Actualizar Conta");
            System.out.println("3.-Eliminar Registo");
            System.out.print("\n\nDiguite uma opção:  ");
            acao = Ler.dadoInt(); //Escolher a opção via teclado
            
            //Arranjo de condições
            switch(acao){
                case 1:
                    actualizarCliente(pos);//Metudo
                break;
                
                case 2:
                    actualizarConta(pos);//Metudo
                break;
                
                case 3:
                    eliminarRegistro(pos);//Metudo
                break;
                
                default : 
                    System.out.println("Opção Inválida!");
            }
     }else{
              System.out.println("Resgistro não existe!");
           
        }
           
    }
     
          //3-Metudo para Eliminar Registro
    private static void eliminarRegistro(int pos) {
        
    //Variavel local
    int acao = 0;
    int posicao = -1;
    int num = 0;
    int cant = 0;
    
    //Menu de opção: 
    System.out.println("\n\n-- MENU DE OPÇÕES --");
    System.out.println("1.-Eliminar Clientes");
    System.out.println("2.-Eliminar Contas");
    acao = Ler.dadoInt();
    
    
    //Arranjo de opção
    switch(acao){
        case 1:
            for(int i = pos; i < cont ; i++){
                cliente[i] = cliente[i+1];
            }
            cont--;
          System.out.println("Clientes eliminado");  
          break;
        case 2:
             System.out.println("\n\nInsira o numero da conta a ser eliminada: ");
           num = Ler.dadoInt();
           posicao = buscarConta(posicao, num);
           if(posicao >= 0){
               cant = cliente[pos].getCant();
               for(int i = posicao; i < cant -1; i++){
                   cliente[pos].getConta()[i] = cliente[pos].getConta()[i+1];
               }
               cant--;
               cliente[pos].setCant(cant);// Modifica o contador interno
                System.out.println("Conta eliminada!");
           }else{
                System.out.println("O registro não existe!");
           }
             break;
        default:
             System.out.println("Opção inválida!");
    }
     
    
    }

          //4-Metudo para Modificar Cliente 
 private static void actualizarCliente(int pos) {
     
     //Variavel local
     String Nif;
     String Nome;
     String Telefone;
     String Cidade;
     int modo = 0;
     int seje = -1;
    
     //Menu de opção
     while(seje == 1){
     System.out.println("\n\n\n-- MENU DE MODIFICAÇÃO DE CLIENTE --");
     System.out.println("1.-Modificar Nif");
     System.out.println("2.-Modificar Nome");
     System.out.println("3.-Modificar Telefone");
     System.out.println("4.-Modificar Cidade");
     System.out.print("Escolhe a opção"); 
     modo = Ler.dadoInt();
     
     //Arranjo de modificação
     switch(modo){
         case 1:
          System.out.print("Nif"); 
          Nif = Ler.dado();
          cliente[pos].setNif(Nif);
          break;
         case 2:
          System.out.print("Nome"); 
          Nome = Ler.dado();
          cliente[pos].setNome(Nome);
          break;
         case 3:
          System.out.print("Telefone"); 
          Telefone = Ler.dado();
          cliente[pos].setTelefone(Telefone);
          break;
         case 4:
          System.out.print("Cidade"); 
          Cidade = Ler.dado();
          cliente[pos].setCidade(Cidade);
          break;
         default :
             System.out.print("Opção inválida!"); 
     }
     
     System.out.println("\n\n\n"); 
     System.out.print("----------------------------"); 
     System.out.println("1.-Seguir modificando"); 
     System.out.println("2.-Parar de modificar"); 
     System.out.print("Escolhe a opção"); 
     seje = Ler.dadoInt();
     }
        
   }
 
  
         //5-Metudo para Modificar Conta
    private static void actualizarConta(int pos) {
        
    //Variaveis locais
    int num = 0;
    int saldo = 0;
    int siga = 1;
    int modo = 0;
    int posi = 0;
    String tipo = null;
    
    //Mensagem de solicitação
    System.out.println("\n\nDigite o número de conta que quer modificar: ");
    num = Ler.dadoInt();
    posi = buscarConta(posi, num);
    System.out.println("Aviso!");
    
   
    if(posi >=0){
         System.out.println("\n\nConta encontrada!");
         System.out.println("" + cliente[pos].getConta()[posi].toString());
         
       while(siga == 1){
        System.out.println("\n\n-- MENU DE OPÇÕES --");
        System.out.println("1.-Modificar Tipo");
        System.out.println("1.-Modificar Saldo");
        System.out.print("Escolhe uma opção");
        modo = Ler.dadoInt();
        
        switch (modo){
            case 1:
                System.out.print("Tipo de Conta: ");
                tipo = Ler.dado();
                cliente[pos].getConta()[posi].setTipo(tipo);
                break;
            case 2:
                System.out.print("Mudar Saldo: ");
                saldo = Ler.dadoInt();
                cliente[pos].getConta()[posi].setSaldo(saldo);
                break;
            default:
              System.out.println("Opção inválida!");  
        }
        
        System.out.println("\n\n-- Menu de opções --");
        System.out.println("1.-Seguir modificando");
        System.out.println("2.-Parar de modificar");
        System.out.print("Escolhe uma opção");
        siga = Ler.dadoInt();
       }  
    }else{
         System.out.print("Conta não existente!");
    }
    
    }
    
        //6-Metudo para Buscar Conta 
     private static int buscarConta(int posicao, int num) {
        
     //Variaveis locais
     int posi = -1;
     int cant = cliente[posicao].getCant();
     for(int i = 0; i < cant ; i++ ){
       if(cliente[posicao].getConta()[i].getNum() == num) {
           posi = i;
        System.out.println("\n\nConta encontrada na posição: " + i);
       }  
     }
     return posi;
 }
    

     //7-Metudo para Buscar Cliente
    private static int buscarCliente(String Nif) {
       
    //Variaveis locais
    int pos = -1;
    for(int i = 0; i < cont; i++){
        if(cliente[i].getNif().equals(Nif)){
        pos = i;
         System.out.println("\nRegistro Modificado!");
    }
        
    }
    return pos;
  }
    
     //8-Metudo para Tranzações --> "Gerencia e Deposito"
          private static void tranzacoes() {
              //Variaveis locais
         String Nif = null;
         int numConta = 0;
         int saldo = 0;
         int valor = 0;
         int pos = -1; //posicão
         int cant = 0;
         int posicaoInterna = -1;
         int acao = 0;
         
         //Solicitação de dados 
         System.out.print("\nInsira o número de Nif: ");
         Nif = Ler.dado();
         pos = buscarCliente(Nif);
         
         if(pos >= 0){
             System.out.println("\n\n -- DADOS --");
             System.out.println("" + cliente[pos].toString());
             cant = cliente[pos].getCant();
             for(int i = 0; i < cant ; i++ ){
                 System.out.println("\n\nConta: " + cliente[pos].getConta()[i].toString());
            
                 System.out.println("\n\nDigite o número da Conta: ");
                 numConta = Ler.dadoInt();
                 posicaoInterna = buscarConta(pos, numConta);
                 
                 if(posicaoInterna >= 0){
                     System.out.println("\n\nConta encontrada: " + cliente[pos].getConta()[posicaoInterna].toString());
                
                     System.out.println("\n\nMenu de opções: ");
                     System.out.println("1.-Gerir $");
                     System.out.println("2.-Depositar $");
                     System.out.print("Escolhe uma opção: ");
                     acao = Ler.dadoInt();
                     saldo = cliente[pos].getConta()[posicaoInterna].getSaldo();
                     
                     switch(acao){
                         case 1:
                            System.out.println("Valor a gerir: "); 
                            valor = Ler.dadoInt();
                            cliente[pos].getConta()[posicaoInterna].setSaldo(saldo - valor);
                             break;
                         case 2:
                             System.out.println("Valor a depositar: $"); 
                             valor = Ler.dadoInt();
                             cliente[pos].getConta()[posicaoInterna].setSaldo(saldo + valor);
                             break;
                         default:
                             System.out.println("\n\nError de Sistema"); 
                    }
                     System.out.println("\n\nConta atualizada com sucesso!"); 
                     System.out.println("" + cliente[pos].getConta()[posicaoInterna].toString()); 
                 }else{
                    System.out.println("Registro não encontrado!"); 
                 }
             }
             }else{
                   System.out.println("Registro não encontrado!"); 
                  }
             }
       
     
    //9-Metudo para Buscar Cliente
    private static void listarClientes() {
        
    int cant = 0;
    for(int i = 0; i < cont; i++){
        System.out.println("\n\nCliente: " +cliente[i].toString());
        cant = cliente[i].getCant();
        for(int j = 0; j < cant; i++){
          System.out.println("\n\nConta: " + cliente[i].getConta()[j].toString());  
        }
    }
   }

  }
    

