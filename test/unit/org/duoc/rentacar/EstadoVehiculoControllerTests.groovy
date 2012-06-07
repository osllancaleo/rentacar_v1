package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(EstadoVehiculoController)
@Mock(EstadoVehiculo)
class EstadoVehiculoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/estadoVehiculo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.estadoVehiculoInstanceList.size() == 0
        assert model.estadoVehiculoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.estadoVehiculoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.estadoVehiculoInstance != null
        assert view == '/estadoVehiculo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/estadoVehiculo/show/1'
        assert controller.flash.message != null
        assert EstadoVehiculo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoVehiculo/list'


        populateValidParams(params)
        def estadoVehiculo = new EstadoVehiculo(params)

        assert estadoVehiculo.save() != null

        params.id = estadoVehiculo.id

        def model = controller.show()

        assert model.estadoVehiculoInstance == estadoVehiculo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoVehiculo/list'


        populateValidParams(params)
        def estadoVehiculo = new EstadoVehiculo(params)

        assert estadoVehiculo.save() != null

        params.id = estadoVehiculo.id

        def model = controller.edit()

        assert model.estadoVehiculoInstance == estadoVehiculo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoVehiculo/list'

        response.reset()


        populateValidParams(params)
        def estadoVehiculo = new EstadoVehiculo(params)

        assert estadoVehiculo.save() != null

        // test invalid parameters in update
        params.id = estadoVehiculo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/estadoVehiculo/edit"
        assert model.estadoVehiculoInstance != null

        estadoVehiculo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/estadoVehiculo/show/$estadoVehiculo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        estadoVehiculo.clearErrors()

        populateValidParams(params)
        params.id = estadoVehiculo.id
        params.version = -1
        controller.update()

        assert view == "/estadoVehiculo/edit"
        assert model.estadoVehiculoInstance != null
        assert model.estadoVehiculoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/estadoVehiculo/list'

        response.reset()

        populateValidParams(params)
        def estadoVehiculo = new EstadoVehiculo(params)

        assert estadoVehiculo.save() != null
        assert EstadoVehiculo.count() == 1

        params.id = estadoVehiculo.id

        controller.delete()

        assert EstadoVehiculo.count() == 0
        assert EstadoVehiculo.get(estadoVehiculo.id) == null
        assert response.redirectedUrl == '/estadoVehiculo/list'
    }
}
