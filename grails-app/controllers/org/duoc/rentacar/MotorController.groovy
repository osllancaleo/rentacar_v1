package org.duoc.rentacar

import org.springframework.dao.DataIntegrityViolationException

class MotorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [motorInstanceList: Motor.list(params), motorInstanceTotal: Motor.count()]
    }

    def create() {
        [motorInstance: new Motor(params)]
    }

    def save() {
        def motorInstance = new Motor(params)
        if (!motorInstance.save(flush: true)) {
            render(view: "create", model: [motorInstance: motorInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'motor.label', default: 'Motor'), motorInstance.id])
        redirect(action: "show", id: motorInstance.id)
    }

    def show() {
        def motorInstance = Motor.get(params.id)
        if (!motorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'motor.label', default: 'Motor'), params.id])
            redirect(action: "list")
            return
        }

        [motorInstance: motorInstance]
    }

    def edit() {
        def motorInstance = Motor.get(params.id)
        if (!motorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'motor.label', default: 'Motor'), params.id])
            redirect(action: "list")
            return
        }

        [motorInstance: motorInstance]
    }

    def update() {
        def motorInstance = Motor.get(params.id)
        if (!motorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'motor.label', default: 'Motor'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (motorInstance.version > version) {
                motorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'motor.label', default: 'Motor')] as Object[],
                          "Another user has updated this Motor while you were editing")
                render(view: "edit", model: [motorInstance: motorInstance])
                return
            }
        }

        motorInstance.properties = params

        if (!motorInstance.save(flush: true)) {
            render(view: "edit", model: [motorInstance: motorInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'motor.label', default: 'Motor'), motorInstance.id])
        redirect(action: "show", id: motorInstance.id)
    }

    def delete() {
        def motorInstance = Motor.get(params.id)
        if (!motorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'motor.label', default: 'Motor'), params.id])
            redirect(action: "list")
            return
        }

        try {
            motorInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'motor.label', default: 'Motor'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'motor.label', default: 'Motor'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
