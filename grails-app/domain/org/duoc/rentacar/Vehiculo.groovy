package org.duoc.rentacar

class Vehiculo {
    String patente
    int anio
    int valorDia
    int valorHora
    Boolean  airBag
    Boolean cierreCentralizado
    String rendimiento
    int cantidadPasajero
    //String imagen
    static belongsTo = [color: Color, tipovehiculo : TipoVehiculo,modelo : Modelo, estadovehiculo: EstadoVehiculo, sucursal: Sucursal,motor: Motor]
    static constraints = {
        patente blank: false, size: 6..6, unique: true
        anio  blank: false, min: 1995
        //imagen blank: false
        valorDia blank: false, min: 1
        valorHora blank: false, min: 1
        rendimiento blank: false, size: 2..50
        cantidadPasajero blank: false, min: 2, max: 40
    }
}
