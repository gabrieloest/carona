package carona

import org.springframework.dao.DataIntegrityViolationException

class TrajetoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [trajetoInstanceList: Trajeto.list(params), trajetoInstanceTotal: Trajeto.count()]
    }

    def create() {
        [trajetoInstance: new Trajeto(params)]
    }

    def save() {
        def trajetoInstance = new Trajeto(params)
        if (!trajetoInstance.save(flush: true)) {
            render(view: "create", model: [trajetoInstance: trajetoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'trajeto.label', default: 'Trajeto'), trajetoInstance.id])
        redirect(action: "show", id: trajetoInstance.id)
    }

    def show(Long id) {
        def trajetoInstance = Trajeto.get(id)
        if (!trajetoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trajeto.label', default: 'Trajeto'), id])
            redirect(action: "list")
            return
        }

        [trajetoInstance: trajetoInstance]
    }

    def edit(Long id) {
        def trajetoInstance = Trajeto.get(id)
        if (!trajetoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trajeto.label', default: 'Trajeto'), id])
            redirect(action: "list")
            return
        }

        [trajetoInstance: trajetoInstance]
    }

    def update(Long id, Long version) {
        def trajetoInstance = Trajeto.get(id)
        if (!trajetoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trajeto.label', default: 'Trajeto'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (trajetoInstance.version > version) {
                trajetoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'trajeto.label', default: 'Trajeto')] as Object[],
                          "Another user has updated this Trajeto while you were editing")
                render(view: "edit", model: [trajetoInstance: trajetoInstance])
                return
            }
        }

        trajetoInstance.properties = params

        if (!trajetoInstance.save(flush: true)) {
            render(view: "edit", model: [trajetoInstance: trajetoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'trajeto.label', default: 'Trajeto'), trajetoInstance.id])
        redirect(action: "show", id: trajetoInstance.id)
    }

    def delete(Long id) {
        def trajetoInstance = Trajeto.get(id)
        if (!trajetoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trajeto.label', default: 'Trajeto'), id])
            redirect(action: "list")
            return
        }

        try {
            trajetoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'trajeto.label', default: 'Trajeto'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'trajeto.label', default: 'Trajeto'), id])
            redirect(action: "show", id: id)
        }
    }
}
