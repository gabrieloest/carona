package carona



import org.junit.*
import grails.test.mixin.*

@TestFor(CaronaController)
@Mock(Carona)
class CaronaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/carona/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.caronaInstanceList.size() == 0
        assert model.caronaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.caronaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.caronaInstance != null
        assert view == '/carona/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/carona/show/1'
        assert controller.flash.message != null
        assert Carona.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/carona/list'

        populateValidParams(params)
        def carona = new Carona(params)

        assert carona.save() != null

        params.id = carona.id

        def model = controller.show()

        assert model.caronaInstance == carona
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/carona/list'

        populateValidParams(params)
        def carona = new Carona(params)

        assert carona.save() != null

        params.id = carona.id

        def model = controller.edit()

        assert model.caronaInstance == carona
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/carona/list'

        response.reset()

        populateValidParams(params)
        def carona = new Carona(params)

        assert carona.save() != null

        // test invalid parameters in update
        params.id = carona.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/carona/edit"
        assert model.caronaInstance != null

        carona.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/carona/show/$carona.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        carona.clearErrors()

        populateValidParams(params)
        params.id = carona.id
        params.version = -1
        controller.update()

        assert view == "/carona/edit"
        assert model.caronaInstance != null
        assert model.caronaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/carona/list'

        response.reset()

        populateValidParams(params)
        def carona = new Carona(params)

        assert carona.save() != null
        assert Carona.count() == 1

        params.id = carona.id

        controller.delete()

        assert Carona.count() == 0
        assert Carona.get(carona.id) == null
        assert response.redirectedUrl == '/carona/list'
    }
}
