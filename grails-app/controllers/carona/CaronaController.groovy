package carona

import org.springframework.dao.DataIntegrityViolationException

class CaronaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [caronaInstanceList: Carona.list(params), caronaInstanceTotal: Carona.count()]
    }

    def create() {
        [caronaInstance: new Carona(params)]
    }

    def save() {
        def caronaInstance = new Carona(params)
        if (!caronaInstance.save(flush: true)) {
            render(view: "create", model: [caronaInstance: caronaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'carona.label', default: 'Carona'), caronaInstance.id])
        redirect(action: "show", id: caronaInstance.id)
    }

    def show(Long id) {
        def caronaInstance = Carona.get(id)
        if (!caronaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'carona.label', default: 'Carona'), id])
            redirect(action: "list")
            return
        }

        [caronaInstance: caronaInstance]
    }

    def edit(Long id) {
        def caronaInstance = Carona.get(id)
        if (!caronaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'carona.label', default: 'Carona'), id])
            redirect(action: "list")
            return
        }

        [caronaInstance: caronaInstance]
    }

    def update(Long id, Long version) {
        def caronaInstance = Carona.get(id)
        if (!caronaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'carona.label', default: 'Carona'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (caronaInstance.version > version) {
                caronaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'carona.label', default: 'Carona')] as Object[],
                          "Another user has updated this Carona while you were editing")
                render(view: "edit", model: [caronaInstance: caronaInstance])
                return
            }
        }

        caronaInstance.properties = params

        if (!caronaInstance.save(flush: true)) {
            render(view: "edit", model: [caronaInstance: caronaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'carona.label', default: 'Carona'), caronaInstance.id])
        redirect(action: "show", id: caronaInstance.id)
    }

    def delete(Long id) {
        def caronaInstance = Carona.get(id)
        if (!caronaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'carona.label', default: 'Carona'), id])
            redirect(action: "list")
            return
        }

        try {
            caronaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'carona.label', default: 'Carona'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'carona.label', default: 'Carona'), id])
            redirect(action: "show", id: id)
        }
    }
}
