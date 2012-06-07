package org.duoc.rentacar

class Provincia {
    String nombre
    static belongsTo = [region : Region]
    static hasMany = [comunas : Comuna]
    String toString(){
        return nombre
    }
    static constraints = {
        nombre blank: false, size: 2..50, unique: true
    }
}
