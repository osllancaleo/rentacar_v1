package org.duoc.rentacar

class Color {
    String nombre
    String toString(){
        return nombre
    }
    static constraints = {
        nombre blank: false, size: 2..50, unique: true
    }
}
