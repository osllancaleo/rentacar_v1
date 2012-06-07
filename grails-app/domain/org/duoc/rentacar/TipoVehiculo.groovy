package org.duoc.rentacar

class TipoVehiculo {
    String nombre
    String toString(){
        return nombre
    }
    static constraints = {
        nombre blank: false, size: 2..30, unique: true
    }
}
