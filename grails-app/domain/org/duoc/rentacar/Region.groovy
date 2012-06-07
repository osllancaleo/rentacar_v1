package org.duoc.rentacar

class Region {
    String nombre
    static hasMany = [provincias : Provincia]
    String toString(){
        return nombre
    }

    static constraints = {
        nombre blank: false, size: 2..50, unique: true
    }
}
