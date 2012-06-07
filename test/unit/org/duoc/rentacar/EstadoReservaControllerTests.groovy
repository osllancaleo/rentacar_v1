package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(EstadoReservaController)
@Mock(EstadoReserva)
class EstadoReservaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/estadoReserva/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.estadoReservaInstanceList.size() == 0
        assert model.estadoReservaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.estadoReservaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.estadoReservaInstance != null
        assert view == '/estadoReserva/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/estadoReserva/show/1'
        assert controller.flash.message != null
        assert EstadoReserva.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoReserva/list'


        populateValidParams(params)
        def estadoReserva = new EstadoReserva(params)

        assert estadoReserva.save() != null

        params.id = estadoReserva.id

        def model = controller.show()

        assert model.estadoReservaInstance == estadoReserva
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoReserva/list'


        populateValidParams(params)
        def estadoReserva = new EstadoReserva(params)

        assert estadoReserva.save() != null

        params.id = estadoReserva.id

        def model = controller.edit()

        assert model.estadoReservaInstance == estadoReserva
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoReserva/list'

        response.reset()


        populateValidParams(params)
        def estadoReserva = new EstadoReserva(params)

        assert estadoReserva.save() != null

        // test invalid parameters in update
        params.id = estadoReserva.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/estadoReserva/edit"
        assert model.estadoReservaInstance != null

        estadoReserva.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/estadoReserva/show/$estadoReserva.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        estadoReserva.clearErrors()

        populateValidParams(params)
        params.id = estadoReserva.id
        params.version = -1
        controller.update()

        assert view == "/estadoReserva/edit"
        assert model.estadoReservaInstance != null
        assert model.estadoReservaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/estadoReserva/list'

        response.reset()

        populateValidParams(params)
        def estadoReserva = new EstadoReserva(params)

        assert estadoReserva.save() != null
        assert EstadoReserva.count() == 1

        params.id = estadoReserva.id

        controller.delete()

        assert EstadoReserva.count() == 0
        assert EstadoReserva.get(estadoReserva.id) == null
        assert response.redirectedUrl == '/estadoReserva/list'
    }
}
