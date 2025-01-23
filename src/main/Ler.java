/*Esta classe se ocupara na captura dos dados do teclado e substituindo pelo tipo Scan */

package main;

import java.io.*;

public class Ler {
    
    //Metudo para capturar dado do tipo Srting
 public static String dado(){
 
     String sdado = null;
     
     try{
         BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
         sdado = entrada.readLine();   
     } catch(IOException e){
         System.out.println("Error: " +e.getMessage());
     }
     return sdado;
     
     }
 
 //Metudo para capturar dado do tipo Inteiro
     public static int dadoInt(){
         try{
             return(Integer.parseInt (dado()));
         }catch(NumberFormatException error){
             return (Integer.MIN_VALUE);
         }
     }
     
     //Metudo para capturar dado do tipo Float
     public static float dadoFloat(){
       try{
           Float f = new Float(dado());
           return (f.floatValue());
       } catch (NumberFomatException error){
           return (Float.NaN);
       }
     }
   
     //Metudo para capturar dado do tipo Double
     public static double dadoDouble(){
         try{
             Double f = new Double (dado());
             return (f.doubleValue());
         }catch (NumberFomatException error){
             return (Double.NaN);
         }
     }
     
     //Metudo para capturar dado do tipo Char
     public static char dadoChar(){
         try{
             char resp = dado().charAt(0);
             return resp;
         }catch (Exception error){
             return ("z");
         }
     }
 
     
     //Metudo para capturar dado do tipo Boolean
     public static boolean dadoBoolean(){
         try{
             return (Boolean.parseBoolean(dado()));
         }catch (NumberFomatException error);
         return (false);
     }
}


