package org.duoc.rentacar

import org.springframework.dao.DataIntegrityViolationException

class EstadoVehiculoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [estadoVehiculoInstanceList: EstadoVehiculo.list(params), estadoVehiculoInstanceTotal: EstadoVehiculo.count()]
    }

    def create() {
        [estadoVehiculoInstance: new EstadoVehiculo(params)]
    }

    def save() {
        def estadoVehiculoInstance = new EstadoVehiculo(params)
        if (!estadoVehiculoInstance.save(flush: true)) {
            render(view: "create", model: [estadoVehiculoInstance: estadoVehiculoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo'), estadoVehiculoInstance.id])
        redirect(action: "show", id: estadoVehiculoInstance.id)
    }

    def show() {
        def estadoVehiculoInstance = EstadoVehiculo.get(params.id)
        if (!estadoVehiculoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo'), params.id])
            redirect(action: "list")
            return
        }

        [estadoVehiculoInstance: estadoVehiculoInstance]
    }

    def edit() {
        def estadoVehiculoInstance = EstadoVehiculo.get(params.id)
        if (!estadoVehiculoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo'), params.id])
            redirect(action: "list")
            return
        }

        [estadoVehiculoInstance: estadoVehiculoInstance]
    }

    def update() {
        def estadoVehiculoInstance = EstadoVehiculo.get(params.id)
        if (!estadoVehiculoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (estadoVehiculoInstance.version > version) {
                estadoVehiculoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo')] as Object[],
                          "Another user has updated this EstadoVehiculo while you were editing")
                render(view: "edit", model: [estadoVehiculoInstance: estadoVehiculoInstance])
                return
            }
        }

        estadoVehiculoInstance.properties = params

        if (!estadoVehiculoInstance.save(flush: true)) {
            render(view: "edit", model: [estadoVehiculoInstance: estadoVehiculoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo'), estadoVehiculoInstance.id])
        redirect(action: "show", id: estadoVehiculoInstance.id)
    }

    def delete() {
        def estadoVehiculoInstance = EstadoVehiculo.get(params.id)
        if (!estadoVehiculoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo'), params.id])
            redirect(action: "list")
            return
        }

        try {
            estadoVehiculoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'estadoVehiculo.label', default: 'EstadoVehiculo'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
