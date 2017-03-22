/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saladecine;

/**
 *
 * @author Tatiana Almansa
 * @author Juan David Ojeda
 */
public class Silla {
    private int numero;
    private TipoSilla tipoSilla;
    private Persona persona;

    public Silla(int numero, TipoSilla tipoSilla, Persona persona) {
        this.numero = numero;
        this.tipoSilla = tipoSilla;
        this.persona = persona;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoSilla getTipoSilla() {
        return tipoSilla;
    }

    public void setTipoSilla(TipoSilla tipoSilla) {
        this.tipoSilla = tipoSilla;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}


