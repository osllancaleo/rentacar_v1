package org.duoc.rentacar

import org.springframework.dao.DataIntegrityViolationException

class ComunaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [comunaInstanceList: Comuna.list(params), comunaInstanceTotal: Comuna.count()]
    }

    def create() {
        [comunaInstance: new Comuna(params)]
    }

    def save() {
        def comunaInstance = new Comuna(params)
        if (!comunaInstance.save(flush: true)) {
            render(view: "create", model: [comunaInstance: comunaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'comuna.label', default: 'Comuna'), comunaInstance.id])
        redirect(action: "show", id: comunaInstance.id)
    }

    def show() {
        def comunaInstance = Comuna.get(params.id)
        if (!comunaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'comuna.label', default: 'Comuna'), params.id])
            redirect(action: "list")
            return
        }

        [comunaInstance: comunaInstance]
    }

    def edit() {
        def comunaInstance = Comuna.get(params.id)
        if (!comunaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'comuna.label', default: 'Comuna'), params.id])
            redirect(action: "list")
            return
        }

        [comunaInstance: comunaInstance]
    }

    def update() {
        def comunaInstance = Comuna.get(params.id)
        if (!comunaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'comuna.label', default: 'Comuna'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (comunaInstance.version > version) {
                comunaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'comuna.label', default: 'Comuna')] as Object[],
                          "Another user has updated this Comuna while you were editing")
                render(view: "edit", model: [comunaInstance: comunaInstance])
                return
            }
        }

        comunaInstance.properties = params

        if (!comunaInstance.save(flush: true)) {
            render(view: "edit", model: [comunaInstance: comunaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'comuna.label', default: 'Comuna'), comunaInstance.id])
        redirect(action: "show", id: comunaInstance.id)
    }

    def delete() {
        def comunaInstance = Comuna.get(params.id)
        if (!comunaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'comuna.label', default: 'Comuna'), params.id])
            redirect(action: "list")
            return
        }

        try {
            comunaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'comuna.label', default: 'Comuna'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'comuna.label', default: 'Comuna'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
