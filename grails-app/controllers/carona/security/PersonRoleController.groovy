package carona.security

import org.springframework.dao.DataIntegrityViolationException

class PersonRoleController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [personRoleInstanceList: PersonRole.list(params), personRoleInstanceTotal: PersonRole.count()]
    }

    def create() {
        [personRoleInstance: new PersonRole(params)]
    }

    def save() {
        def personRoleInstance = new PersonRole(params)
        if (!personRoleInstance.save(flush: true)) {
            render(view: "create", model: [personRoleInstance: personRoleInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'personRole.label', default: 'PersonRole'), personRoleInstance.id])
        redirect(action: "show", id: personRoleInstance.id)
    }

    def show(Long id) {
        def personRoleInstance = PersonRole.get(id)
        if (!personRoleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'personRole.label', default: 'PersonRole'), id])
            redirect(action: "list")
            return
        }

        [personRoleInstance: personRoleInstance]
    }

    def edit(Long id) {
        def personRoleInstance = PersonRole.get(id)
        if (!personRoleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'personRole.label', default: 'PersonRole'), id])
            redirect(action: "list")
            return
        }

        [personRoleInstance: personRoleInstance]
    }

    def update(Long id, Long version) {
        def personRoleInstance = PersonRole.get(id)
        if (!personRoleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'personRole.label', default: 'PersonRole'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (personRoleInstance.version > version) {
                personRoleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'personRole.label', default: 'PersonRole')] as Object[],
                          "Another user has updated this PersonRole while you were editing")
                render(view: "edit", model: [personRoleInstance: personRoleInstance])
                return
            }
        }

        personRoleInstance.properties = params

        if (!personRoleInstance.save(flush: true)) {
            render(view: "edit", model: [personRoleInstance: personRoleInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'personRole.label', default: 'PersonRole'), personRoleInstance.id])
        redirect(action: "show", id: personRoleInstance.id)
    }

    def delete(Long id) {
        def personRoleInstance = PersonRole.get(id)
        if (!personRoleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'personRole.label', default: 'PersonRole'), id])
            redirect(action: "list")
            return
        }

        try {
            personRoleInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'personRole.label', default: 'PersonRole'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'personRole.label', default: 'PersonRole'), id])
            redirect(action: "show", id: id)
        }
    }
}
