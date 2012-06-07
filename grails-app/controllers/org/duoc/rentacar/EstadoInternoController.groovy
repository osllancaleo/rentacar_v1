package org.duoc.rentacar

import org.springframework.dao.DataIntegrityViolationException

class EstadoInternoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [estadoInternoInstanceList: EstadoInterno.list(params), estadoInternoInstanceTotal: EstadoInterno.count()]
    }

    def create() {
        [estadoInternoInstance: new EstadoInterno(params)]
    }

    def save() {
        def estadoInternoInstance = new EstadoInterno(params)
        if (!estadoInternoInstance.save(flush: true)) {
            render(view: "create", model: [estadoInternoInstance: estadoInternoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'estadoInterno.label', default: 'EstadoInterno'), estadoInternoInstance.id])
        redirect(action: "show", id: estadoInternoInstance.id)
    }

    def show() {
        def estadoInternoInstance = EstadoInterno.get(params.id)
        if (!estadoInternoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoInterno.label', default: 'EstadoInterno'), params.id])
            redirect(action: "list")
            return
        }

        [estadoInternoInstance: estadoInternoInstance]
    }

    def edit() {
        def estadoInternoInstance = EstadoInterno.get(params.id)
        if (!estadoInternoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoInterno.label', default: 'EstadoInterno'), params.id])
            redirect(action: "list")
            return
        }

        [estadoInternoInstance: estadoInternoInstance]
    }

    def update() {
        def estadoInternoInstance = EstadoInterno.get(params.id)
        if (!estadoInternoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoInterno.label', default: 'EstadoInterno'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (estadoInternoInstance.version > version) {
                estadoInternoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'estadoInterno.label', default: 'EstadoInterno')] as Object[],
                          "Another user has updated this EstadoInterno while you were editing")
                render(view: "edit", model: [estadoInternoInstance: estadoInternoInstance])
                return
            }
        }

        estadoInternoInstance.properties = params

        if (!estadoInternoInstance.save(flush: true)) {
            render(view: "edit", model: [estadoInternoInstance: estadoInternoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'estadoInterno.label', default: 'EstadoInterno'), estadoInternoInstance.id])
        redirect(action: "show", id: estadoInternoInstance.id)
    }

    def delete() {
        def estadoInternoInstance = EstadoInterno.get(params.id)
        if (!estadoInternoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'estadoInterno.label', default: 'EstadoInterno'), params.id])
            redirect(action: "list")
            return
        }

        try {
            estadoInternoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'estadoInterno.label', default: 'EstadoInterno'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'estadoInterno.label', default: 'EstadoInterno'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
