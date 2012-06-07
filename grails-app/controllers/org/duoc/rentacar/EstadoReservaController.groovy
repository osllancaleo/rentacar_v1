package org.duoc.rentacar

import org.springframework.dao.DataIntegrityViolationException

class EstadoReservaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [estadoReservaInstanceList: EstadoReserva.list(params), estadoReservaInstanceTotal: EstadoReserva.count()]
    }

    def create() {
        [estadoReservaInstance: new EstadoReserva(params)]
    }

    def save() {
        def estadoReservaInstance = new EstadoReserva(params)
        if (!estadoReservaInstance.save(flush: true)) {
            render(view: "create", model: [estadoReservaInstance: estadoReservaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'estadoReserva.label', default: 'EstadoReserva'), estadoReservaInstance.id])
        redirect(action: "show", id: estadoReservaInstance.id)
    }

    def show() {
        def estadoReservaInstance = EstadoReserva.get(params.id)
        if (!estadoReservaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoReserva.label', default: 'EstadoReserva'), params.id])
            redirect(action: "list")
            return
        }

        [estadoReservaInstance: estadoReservaInstance]
    }

    def edit() {
        def estadoReservaInstance = EstadoReserva.get(params.id)
        if (!estadoReservaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoReserva.label', default: 'EstadoReserva'), params.id])
            redirect(action: "list")
            return
        }

        [estadoReservaInstance: estadoReservaInstance]
    }

    def update() {
        def estadoReservaInstance = EstadoReserva.get(params.id)
        if (!estadoReservaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoReserva.label', default: 'EstadoReserva'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (estadoReservaInstance.version > version) {
                estadoReservaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'estadoReserva.label', default: 'EstadoReserva')] as Object[],
                          "Another user has updated this EstadoReserva while you were editing")
                render(view: "edit", model: [estadoReservaInstance: estadoReservaInstance])
                return
            }
        }

        estadoReservaInstance.properties = params

        if (!estadoReservaInstance.save(flush: true)) {
            render(view: "edit", model: [estadoReservaInstance: estadoReservaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'estadoReserva.label', default: 'EstadoReserva'), estadoReservaInstance.id])
        redirect(action: "show", id: estadoReservaInstance.id)
    }

    def delete() {
        def estadoReservaInstance = EstadoReserva.get(params.id)
        if (!estadoReservaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoReserva.label', default: 'EstadoReserva'), params.id])
            redirect(action: "list")
            return
        }

        try {
            estadoReservaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'estadoReserva.label', default: 'EstadoReserva'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'estadoReserva.label', default: 'EstadoReserva'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
