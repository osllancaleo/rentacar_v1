package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(EstadoArriendoController)
@Mock(EstadoArriendo)
class EstadoArriendoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/estadoArriendo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.estadoArriendoInstanceList.size() == 0
        assert model.estadoArriendoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.estadoArriendoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.estadoArriendoInstance != null
        assert view == '/estadoArriendo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/estadoArriendo/show/1'
        assert controller.flash.message != null
        assert EstadoArriendo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoArriendo/list'


        populateValidParams(params)
        def estadoArriendo = new EstadoArriendo(params)

        assert estadoArriendo.save() != null

        params.id = estadoArriendo.id

        def model = controller.show()

        assert model.estadoArriendoInstance == estadoArriendo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoArriendo/list'


        populateValidParams(params)
        def estadoArriendo = new EstadoArriendo(params)

        assert estadoArriendo.save() != null

        params.id = estadoArriendo.id

        def model = controller.edit()

        assert model.estadoArriendoInstance == estadoArriendo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoArriendo/list'

        response.reset()


        populateValidParams(params)
        def estadoArriendo = new EstadoArriendo(params)

        assert estadoArriendo.save() != null

        // test invalid parameters in update
        params.id = estadoArriendo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/estadoArriendo/edit"
        assert model.estadoArriendoInstance != null

        estadoArriendo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/estadoArriendo/show/$estadoArriendo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        estadoArriendo.clearErrors()

        populateValidParams(params)
        params.id = estadoArriendo.id
        params.version = -1
        controller.update()

        assert view == "/estadoArriendo/edit"
        assert model.estadoArriendoInstance != null
        assert model.estadoArriendoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/estadoArriendo/list'

        response.reset()

        populateValidParams(params)
        def estadoArriendo = new EstadoArriendo(params)

        assert estadoArriendo.save() != null
        assert EstadoArriendo.count() == 1

        params.id = estadoArriendo.id

        controller.delete()

        assert EstadoArriendo.count() == 0
        assert EstadoArriendo.get(estadoArriendo.id) == null
        assert response.redirectedUrl == '/estadoArriendo/list'
    }
}
