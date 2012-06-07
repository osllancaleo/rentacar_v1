package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(MarcaController)
@Mock(Marca)
class MarcaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/marca/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.marcaInstanceList.size() == 0
        assert model.marcaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.marcaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.marcaInstance != null
        assert view == '/marca/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/marca/show/1'
        assert controller.flash.message != null
        assert Marca.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/marca/list'


        populateValidParams(params)
        def marca = new Marca(params)

        assert marca.save() != null

        params.id = marca.id

        def model = controller.show()

        assert model.marcaInstance == marca
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/marca/list'


        populateValidParams(params)
        def marca = new Marca(params)

        assert marca.save() != null

        params.id = marca.id

        def model = controller.edit()

        assert model.marcaInstance == marca
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/marca/list'

        response.reset()


        populateValidParams(params)
        def marca = new Marca(params)

        assert marca.save() != null

        // test invalid parameters in update
        params.id = marca.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/marca/edit"
        assert model.marcaInstance != null

        marca.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/marca/show/$marca.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        marca.clearErrors()

        populateValidParams(params)
        params.id = marca.id
        params.version = -1
        controller.update()

        assert view == "/marca/edit"
        assert model.marcaInstance != null
        assert model.marcaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/marca/list'

        response.reset()

        populateValidParams(params)
        def marca = new Marca(params)

        assert marca.save() != null
        assert Marca.count() == 1

        params.id = marca.id

        controller.delete()

        assert Marca.count() == 0
        assert Marca.get(marca.id) == null
        assert response.redirectedUrl == '/marca/list'
    }
}
