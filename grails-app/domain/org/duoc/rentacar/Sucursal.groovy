package org.duoc.rentacar

class Sucursal {
    String nombre
    String direccion
    int fono
    static belongsTo = [comuna : Comuna, estadoInterno: EstadoInterno]
    String toString(){
        return nombre
    }
    static constraints = {
        nombre blank: false, size: 2..50, unique: true
        direccion blank: false, size: 5..80
        fono min: 100000, blank: false
        
    }
}
