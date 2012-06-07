package org.duoc.rentacar

import org.springframework.dao.DataIntegrityViolationException

class EstadoArriendoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [estadoArriendoInstanceList: EstadoArriendo.list(params), estadoArriendoInstanceTotal: EstadoArriendo.count()]
    }

    def create() {
        [estadoArriendoInstance: new EstadoArriendo(params)]
    }

    def save() {
        def estadoArriendoInstance = new EstadoArriendo(params)
        if (!estadoArriendoInstance.save(flush: true)) {
            render(view: "create", model: [estadoArriendoInstance: estadoArriendoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'estadoArriendo.label', default: 'EstadoArriendo'), estadoArriendoInstance.id])
        redirect(action: "show", id: estadoArriendoInstance.id)
    }

    def show() {
        def estadoArriendoInstance = EstadoArriendo.get(params.id)
        if (!estadoArriendoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoArriendo.label', default: 'EstadoArriendo'), params.id])
            redirect(action: "list")
            return
        }

        [estadoArriendoInstance: estadoArriendoInstance]
    }

    def edit() {
        def estadoArriendoInstance = EstadoArriendo.get(params.id)
        if (!estadoArriendoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoArriendo.label', default: 'EstadoArriendo'), params.id])
            redirect(action: "list")
            return
        }

        [estadoArriendoInstance: estadoArriendoInstance]
    }

    def update() {
        def estadoArriendoInstance = EstadoArriendo.get(params.id)
        if (!estadoArriendoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoArriendo.label', default: 'EstadoArriendo'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (estadoArriendoInstance.version > version) {
                estadoArriendoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'estadoArriendo.label', default: 'EstadoArriendo')] as Object[],
                          "Another user has updated this EstadoArriendo while you were editing")
                render(view: "edit", model: [estadoArriendoInstance: estadoArriendoInstance])
                return
            }
        }

        estadoArriendoInstance.properties = params

        if (!estadoArriendoInstance.save(flush: true)) {
            render(view: "edit", model: [estadoArriendoInstance: estadoArriendoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'estadoArriendo.label', default: 'EstadoArriendo'), estadoArriendoInstance.id])
        redirect(action: "show", id: estadoArriendoInstance.id)
    }

    def delete() {
        def estadoArriendoInstance = EstadoArriendo.get(params.id)
        if (!estadoArriendoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoArriendo.label', default: 'EstadoArriendo'), params.id])
            redirect(action: "list")
            return
        }

        try {
            estadoArriendoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'estadoArriendo.label', default: 'EstadoArriendo'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'estadoArriendo.label', default: 'EstadoArriendo'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
