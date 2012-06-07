package org.duoc.rentacar

class Marca {
    String nombre
    String toString(){
        return nombre
    }
    static constraints = {
        nombre blank: false, size: 2..50, unique: true
    }
}
