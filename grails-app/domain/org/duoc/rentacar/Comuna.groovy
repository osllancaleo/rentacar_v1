package org.duoc.rentacar

class Comuna {
    String nombre
    static belongsTo = [provincia : Provincia]
    String toString(){
        return nombre

    }
    static constraints = {
        nombre blank: false, size: 2..50, unique: true
    }
}
