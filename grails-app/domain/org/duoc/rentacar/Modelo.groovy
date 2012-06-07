package org.duoc.rentacar

class Modelo {
    String nombre
    String descripcion

    static belongsTo = [marca: Marca]
    String toString(){
        return nombre
    }
    static constraints = {
        nombre blank: false, size: 2..50, unique: true
        descripcion  blank: false, size: 2..100
    }
}
