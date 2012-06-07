package org.duoc.rentacar

import org.springframework.dao.DataIntegrityViolationException

class ModeloController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [modeloInstanceList: Modelo.list(params), modeloInstanceTotal: Modelo.count()]
    }

    def create() {
        [modeloInstance: new Modelo(params)]
    }

    def save() {
        def modeloInstance = new Modelo(params)
        if (!modeloInstance.save(flush: true)) {
            render(view: "create", model: [modeloInstance: modeloInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'modelo.label', default: 'Modelo'), modeloInstance.id])
        redirect(action: "show", id: modeloInstance.id)
    }

    def show() {
        def modeloInstance = Modelo.get(params.id)
        if (!modeloInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelo.label', default: 'Modelo'), params.id])
            redirect(action: "list")
            return
        }

        [modeloInstance: modeloInstance]
    }

    def edit() {
        def modeloInstance = Modelo.get(params.id)
        if (!modeloInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelo.label', default: 'Modelo'), params.id])
            redirect(action: "list")
            return
        }

        [modeloInstance: modeloInstance]
    }

    def update() {
        def modeloInstance = Modelo.get(params.id)
        if (!modeloInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelo.label', default: 'Modelo'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (modeloInstance.version > version) {
                modeloInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'modelo.label', default: 'Modelo')] as Object[],
                          "Another user has updated this Modelo while you were editing")
                render(view: "edit", model: [modeloInstance: modeloInstance])
                return
            }
        }

        modeloInstance.properties = params

        if (!modeloInstance.save(flush: true)) {
            render(view: "edit", model: [modeloInstance: modeloInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'modelo.label', default: 'Modelo'), modeloInstance.id])
        redirect(action: "show", id: modeloInstance.id)
    }

    def delete() {
        def modeloInstance = Modelo.get(params.id)
        if (!modeloInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelo.label', default: 'Modelo'), params.id])
            redirect(action: "list")
            return
        }

        try {
            modeloInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'modelo.label', default: 'Modelo'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'modelo.label', default: 'Modelo'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
