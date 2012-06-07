package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(SucursalController)
@Mock(Sucursal)
class SucursalControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/sucursal/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.sucursalInstanceList.size() == 0
        assert model.sucursalInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.sucursalInstance != null
    }

    void testSave() {
        controller.save()

        assert model.sucursalInstance != null
        assert view == '/sucursal/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/sucursal/show/1'
        assert controller.flash.message != null
        assert Sucursal.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/sucursal/list'


        populateValidParams(params)
        def sucursal = new Sucursal(params)

        assert sucursal.save() != null

        params.id = sucursal.id

        def model = controller.show()

        assert model.sucursalInstance == sucursal
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/sucursal/list'


        populateValidParams(params)
        def sucursal = new Sucursal(params)

        assert sucursal.save() != null

        params.id = sucursal.id

        def model = controller.edit()

        assert model.sucursalInstance == sucursal
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/sucursal/list'

        response.reset()


        populateValidParams(params)
        def sucursal = new Sucursal(params)

        assert sucursal.save() != null

        // test invalid parameters in update
        params.id = sucursal.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/sucursal/edit"
        assert model.sucursalInstance != null

        sucursal.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/sucursal/show/$sucursal.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        sucursal.clearErrors()

        populateValidParams(params)
        params.id = sucursal.id
        params.version = -1
        controller.update()

        assert view == "/sucursal/edit"
        assert model.sucursalInstance != null
        assert model.sucursalInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/sucursal/list'

        response.reset()

        populateValidParams(params)
        def sucursal = new Sucursal(params)

        assert sucursal.save() != null
        assert Sucursal.count() == 1

        params.id = sucursal.id

        controller.delete()

        assert Sucursal.count() == 0
        assert Sucursal.get(sucursal.id) == null
        assert response.redirectedUrl == '/sucursal/list'
    }
}
