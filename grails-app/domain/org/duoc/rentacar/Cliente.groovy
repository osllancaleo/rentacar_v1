package org.duoc.rentacar

class Cliente {
    String rut
    String apellidoPaterno
    String apellidoMaterno
    String nombre
    Date fechaNacimiento
    String direccion
    int numeroFijo
    int numeroCelular
    String email
    static belongsTo = [comuna : Comuna]
    String toString(){
        return apellidoPaterno + " " + apellidoMaterno + " " + nombre
    }

    static constraints = {
        rut blank: false, size: 6..8, unique: true
        apellidoPaterno blank: false
        nombre blank: false
        fechaNacimiento nullable: false, max: new Date()-18
        email email:true
    }
}
