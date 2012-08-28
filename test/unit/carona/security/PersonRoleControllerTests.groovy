package carona.security



import org.junit.*
import grails.test.mixin.*

@TestFor(PersonRoleController)
@Mock(PersonRole)
class PersonRoleControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/personRole/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personRoleInstanceList.size() == 0
        assert model.personRoleInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.personRoleInstance != null
    }

    void testSave() {
        controller.save()

        assert model.personRoleInstance != null
        assert view == '/personRole/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/personRole/show/1'
        assert controller.flash.message != null
        assert PersonRole.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/personRole/list'

        populateValidParams(params)
        def personRole = new PersonRole(params)

        assert personRole.save() != null

        params.id = personRole.id

        def model = controller.show()

        assert model.personRoleInstance == personRole
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/personRole/list'

        populateValidParams(params)
        def personRole = new PersonRole(params)

        assert personRole.save() != null

        params.id = personRole.id

        def model = controller.edit()

        assert model.personRoleInstance == personRole
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/personRole/list'

        response.reset()

        populateValidParams(params)
        def personRole = new PersonRole(params)

        assert personRole.save() != null

        // test invalid parameters in update
        params.id = personRole.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/personRole/edit"
        assert model.personRoleInstance != null

        personRole.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/personRole/show/$personRole.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        personRole.clearErrors()

        populateValidParams(params)
        params.id = personRole.id
        params.version = -1
        controller.update()

        assert view == "/personRole/edit"
        assert model.personRoleInstance != null
        assert model.personRoleInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/personRole/list'

        response.reset()

        populateValidParams(params)
        def personRole = new PersonRole(params)

        assert personRole.save() != null
        assert PersonRole.count() == 1

        params.id = personRole.id

        controller.delete()

        assert PersonRole.count() == 0
        assert PersonRole.get(personRole.id) == null
        assert response.redirectedUrl == '/personRole/list'
    }
}
