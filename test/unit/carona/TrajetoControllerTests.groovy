package carona



import org.junit.*
import grails.test.mixin.*

@TestFor(TrajetoController)
@Mock(Trajeto)
class TrajetoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/trajeto/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.trajetoInstanceList.size() == 0
        assert model.trajetoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.trajetoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.trajetoInstance != null
        assert view == '/trajeto/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/trajeto/show/1'
        assert controller.flash.message != null
        assert Trajeto.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/trajeto/list'

        populateValidParams(params)
        def trajeto = new Trajeto(params)

        assert trajeto.save() != null

        params.id = trajeto.id

        def model = controller.show()

        assert model.trajetoInstance == trajeto
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/trajeto/list'

        populateValidParams(params)
        def trajeto = new Trajeto(params)

        assert trajeto.save() != null

        params.id = trajeto.id

        def model = controller.edit()

        assert model.trajetoInstance == trajeto
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/trajeto/list'

        response.reset()

        populateValidParams(params)
        def trajeto = new Trajeto(params)

        assert trajeto.save() != null

        // test invalid parameters in update
        params.id = trajeto.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/trajeto/edit"
        assert model.trajetoInstance != null

        trajeto.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/trajeto/show/$trajeto.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        trajeto.clearErrors()

        populateValidParams(params)
        params.id = trajeto.id
        params.version = -1
        controller.update()

        assert view == "/trajeto/edit"
        assert model.trajetoInstance != null
        assert model.trajetoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/trajeto/list'

        response.reset()

        populateValidParams(params)
        def trajeto = new Trajeto(params)

        assert trajeto.save() != null
        assert Trajeto.count() == 1

        params.id = trajeto.id

        controller.delete()

        assert Trajeto.count() == 0
        assert Trajeto.get(trajeto.id) == null
        assert response.redirectedUrl == '/trajeto/list'
    }
}
