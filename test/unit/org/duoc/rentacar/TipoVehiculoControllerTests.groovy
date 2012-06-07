package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(TipoVehiculoController)
@Mock(TipoVehiculo)
class TipoVehiculoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tipoVehiculo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tipoVehiculoInstanceList.size() == 0
        assert model.tipoVehiculoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.tipoVehiculoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tipoVehiculoInstance != null
        assert view == '/tipoVehiculo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tipoVehiculo/show/1'
        assert controller.flash.message != null
        assert TipoVehiculo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoVehiculo/list'


        populateValidParams(params)
        def tipoVehiculo = new TipoVehiculo(params)

        assert tipoVehiculo.save() != null

        params.id = tipoVehiculo.id

        def model = controller.show()

        assert model.tipoVehiculoInstance == tipoVehiculo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoVehiculo/list'


        populateValidParams(params)
        def tipoVehiculo = new TipoVehiculo(params)

        assert tipoVehiculo.save() != null

        params.id = tipoVehiculo.id

        def model = controller.edit()

        assert model.tipoVehiculoInstance == tipoVehiculo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoVehiculo/list'

        response.reset()


        populateValidParams(params)
        def tipoVehiculo = new TipoVehiculo(params)

        assert tipoVehiculo.save() != null

        // test invalid parameters in update
        params.id = tipoVehiculo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tipoVehiculo/edit"
        assert model.tipoVehiculoInstance != null

        tipoVehiculo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tipoVehiculo/show/$tipoVehiculo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tipoVehiculo.clearErrors()

        populateValidParams(params)
        params.id = tipoVehiculo.id
        params.version = -1
        controller.update()

        assert view == "/tipoVehiculo/edit"
        assert model.tipoVehiculoInstance != null
        assert model.tipoVehiculoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tipoVehiculo/list'

        response.reset()

        populateValidParams(params)
        def tipoVehiculo = new TipoVehiculo(params)

        assert tipoVehiculo.save() != null
        assert TipoVehiculo.count() == 1

        params.id = tipoVehiculo.id

        controller.delete()

        assert TipoVehiculo.count() == 0
        assert TipoVehiculo.get(tipoVehiculo.id) == null
        assert response.redirectedUrl == '/tipoVehiculo/list'
    }
}
