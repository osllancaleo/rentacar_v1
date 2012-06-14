package org.duoc.rentacar
import org.duoc.rentacar.Vehiculo

class ListadoAutosController {

    def index() { 
        def v = Vehiculo.get(1)
        render v
    }
}
