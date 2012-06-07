package org.duoc.rentacar

import org.springframework.dao.DataIntegrityViolationException

class TipoVehiculoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [tipoVehiculoInstanceList: TipoVehiculo.list(params), tipoVehiculoInstanceTotal: TipoVehiculo.count()]
    }

    def create() {
        [tipoVehiculoInstance: new TipoVehiculo(params)]
    }

    def save() {
        def tipoVehiculoInstance = new TipoVehiculo(params)
        if (!tipoVehiculoInstance.save(flush: true)) {
            render(view: "create", model: [tipoVehiculoInstance: tipoVehiculoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo'), tipoVehiculoInstance.id])
        redirect(action: "show", id: tipoVehiculoInstance.id)
    }

    def show() {
        def tipoVehiculoInstance = TipoVehiculo.get(params.id)
        if (!tipoVehiculoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo'), params.id])
            redirect(action: "list")
            return
        }

        [tipoVehiculoInstance: tipoVehiculoInstance]
    }

    def edit() {
        def tipoVehiculoInstance = TipoVehiculo.get(params.id)
        if (!tipoVehiculoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo'), params.id])
            redirect(action: "list")
            return
        }

        [tipoVehiculoInstance: tipoVehiculoInstance]
    }

    def update() {
        def tipoVehiculoInstance = TipoVehiculo.get(params.id)
        if (!tipoVehiculoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (tipoVehiculoInstance.version > version) {
                tipoVehiculoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo')] as Object[],
                          "Another user has updated this TipoVehiculo while you were editing")
                render(view: "edit", model: [tipoVehiculoInstance: tipoVehiculoInstance])
                return
            }
        }

        tipoVehiculoInstance.properties = params

        if (!tipoVehiculoInstance.save(flush: true)) {
            render(view: "edit", model: [tipoVehiculoInstance: tipoVehiculoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo'), tipoVehiculoInstance.id])
        redirect(action: "show", id: tipoVehiculoInstance.id)
    }

    def delete() {
        def tipoVehiculoInstance = TipoVehiculo.get(params.id)
        if (!tipoVehiculoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo'), params.id])
            redirect(action: "list")
            return
        }

        try {
            tipoVehiculoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tipoVehiculo.label', default: 'TipoVehiculo'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
