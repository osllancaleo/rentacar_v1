package org.duoc.rentacar

class Motor {
    String nombre
    String toString(){
        return nombre
    }
    static constraints = {
        nombre blank: false, size: 2..20, unique: true
    }
}
