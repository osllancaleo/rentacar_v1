package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(ModeloController)
@Mock(Modelo)
class ModeloControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/modelo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.modeloInstanceList.size() == 0
        assert model.modeloInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.modeloInstance != null
    }

    void testSave() {
        controller.save()

        assert model.modeloInstance != null
        assert view == '/modelo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/modelo/show/1'
        assert controller.flash.message != null
        assert Modelo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/modelo/list'


        populateValidParams(params)
        def modelo = new Modelo(params)

        assert modelo.save() != null

        params.id = modelo.id

        def model = controller.show()

        assert model.modeloInstance == modelo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/modelo/list'


        populateValidParams(params)
        def modelo = new Modelo(params)

        assert modelo.save() != null

        params.id = modelo.id

        def model = controller.edit()

        assert model.modeloInstance == modelo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/modelo/list'

        response.reset()


        populateValidParams(params)
        def modelo = new Modelo(params)

        assert modelo.save() != null

        // test invalid parameters in update
        params.id = modelo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/modelo/edit"
        assert model.modeloInstance != null

        modelo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/modelo/show/$modelo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        modelo.clearErrors()

        populateValidParams(params)
        params.id = modelo.id
        params.version = -1
        controller.update()

        assert view == "/modelo/edit"
        assert model.modeloInstance != null
        assert model.modeloInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/modelo/list'

        response.reset()

        populateValidParams(params)
        def modelo = new Modelo(params)

        assert modelo.save() != null
        assert Modelo.count() == 1

        params.id = modelo.id

        controller.delete()

        assert Modelo.count() == 0
        assert Modelo.get(modelo.id) == null
        assert response.redirectedUrl == '/modelo/list'
    }
}
