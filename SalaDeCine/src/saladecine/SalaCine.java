/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saladecine;

import java.util.Scanner;

/**
 *
 * @author Tatiana Almansa
 * @author Juan David Ojeda
 */
public class SalaCine {
   private int filas;
    private int columnas;
    private int general;
    private int preferencial;
    private int vip;
    private final Silla [][] silla; 

    public SalaCine() {
        teclado = new Scanner(System.in);        
        mensajeBienvenida();     
        darDimencion();
        darClases();
        silla = new Silla[filas][columnas]; 
        ImprimirSilla();
        SillasDisponibles();
    }
    Scanner teclado =new Scanner(System.in);
    private void mensajeBienvenida(){
        System.out.println("-----BIENVENIDO----");
        System.out.println("Ingresa Los Datos");
    }
    private void darDimencion(){
        
        System.out.print("Numero De Filas: ");
        filas = teclado.nextInt();
        System.out.print("Numero de Columnas : ");
        columnas = teclado.nextInt();        
    } 
    
    private void darClases() {
        while(true) {
            System.out.print("Cantidad De Filas Generales : ");
            general = teclado.nextInt();   
            if(general <= filas) 
                break;
        }
        if(general != filas) {
            while(true){
                System.out.print("Cantidad De Filas Preferenciales : ");
                preferencial = teclado.nextInt();   
                if((general + preferencial) <= filas)
                    break;
            }
            vip = filas - (general + preferencial);
        }
    }
    
    private void ImprimirSilla(){
        int contador = 1;
        for(int i=0 ; i< filas ; i++) {
            for(int j=0 ; j< columnas ; j++){
                Silla silla;
                if((i+1) <= general) {
                    silla = new Silla(contador++, TipoSilla.GENERAL, null);
                } 
                else if ((i+1) <= (general + preferencial)) {
                    silla = new Silla(contador++, TipoSilla.PREFERENCIAL, null);
                } 
                else {
                   silla = new Silla(contador++, TipoSilla.EJECUTIVA, null);
                }
                this.silla[i][j] = silla;
            }
        }
        for(int i=0 ; i< filas ; i++) {
            for(int j=0 ; j< columnas ; j++){
                    if(this.silla[i][j].getTipoSilla() == TipoSilla.GENERAL) {
                        System.out.print(+this.silla[i][j].getNumero() + "$$$ ");
                    } else if(this.silla[i][j].getTipoSilla() == TipoSilla.PREFERENCIAL) {
                        System.out.print(+this.silla[i][j].getNumero() + "### ");
                    } else {
                        System.out.print(+this.silla[i][j].getNumero() + "[][] ");
                    }
            }
            System.out.println("");
        }
    }
    
    private void SillasDisponibles(){
        OUTER:
        while (true) {
          System.out.println("ELIGE UNA OPCION");
          if(general!=0){
          System.out.println("1.General");
          }
          if(preferencial != 0){
          System.out.println("2.Preferencial");
          }
          if(vip!=0){
          System.out.println("3.Vip"); 
          }
          System.out.println("4.Salir");
          System.out.println("OPCION");
             byte deseo =  teclado.nextByte();
            switch(deseo){
                case 1:
                    if(general != 0){
                        for(int i=0 ; i< filas ; i++) {
                            for(int j=0 ; j< columnas ; j++){
                                if((this.silla[i][j].getTipoSilla()==TipoSilla.GENERAL)&&(this.silla[i][j].getPersona()==null)){
                                    System.out.print(this.silla[i][j].getNumero()+"$$$ ");
                                    
                                }
                            }
                           System.out.println("");
                        }
                        LlenarSilla();
                        break OUTER;
                    }
                case 2:
                    if(preferencial != 0){
                        for(int i=0 ; i< filas ; i++) {
                            for(int j=0 ; j< columnas ; j++){
                                if((this.silla[i][j].getTipoSilla()==TipoSilla.PREFERENCIAL)&&(this.silla[i][j].getPersona()==null)){
                                    System.out.print(this.silla[i][j].getNumero()+"### ");
                                  
                                }
                            }
                             System.out.println("");
                        }
                        LlenarSilla();
                        break OUTER;
                    }   
                case 3:
                    if(vip != 0){
                        for(int i=0 ; i< filas ; i++) {
                            for(int j=0 ; j< columnas ; j++){
                                if((this.silla[i][j].getTipoSilla()==TipoSilla.EJECUTIVA)&&(this.silla[i][j].getPersona()==null)){
                                    System.out.print(this.silla[i][j].getNumero() + "[][] ");
                                    
                                }
                            }
                             System.out.println("");
                        }
                        LlenarSilla();
                        break OUTER;
                    }
                case 4:
                    break OUTER;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
   }
    private void LlenarSilla(){
       int numero;
       String identificacion;
       String nombre;
       String apellido;
       byte genero;
       byte  edad;
       System.out.print("NUMERO DE SILLA : ");
       numero = teclado.nextInt();
       System.out.print("IDENTIFICACION : ");
       identificacion = teclado.next();
       System.out.print("NOMBRE : ");
       nombre = teclado.next();
       System.out.print("APELLIDO : ");
       apellido = teclado.next();
       System.out.print("EDAD : ");
       edad= teclado.nextByte();
       OUTER:
        while (true) {
            System.out.println("**GENERO**");
            System.out.println("1.MASCULINO");
            System.out.println("2.FEMENINO");
            System.out.print("OPCION DE GENERO : ");
            genero = teclado.nextByte();
            Persona persona;
            switch (genero) {
                case 1:
                    persona = new Persona(identificacion,nombre,apellido,edad,Genero.MASCULINO);
                    break OUTER;
                case 2:
                    persona = new Persona(identificacion,nombre,apellido,edad,Genero.FEMENINO);
                    break OUTER;
                default:
                    System.out.println("ERROR");   
                    break;
            }
        }
   }
   
}
   