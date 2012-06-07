package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(EstadoInternoController)
@Mock(EstadoInterno)
class EstadoInternoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/estadoInterno/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.estadoInternoInstanceList.size() == 0
        assert model.estadoInternoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.estadoInternoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.estadoInternoInstance != null
        assert view == '/estadoInterno/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/estadoInterno/show/1'
        assert controller.flash.message != null
        assert EstadoInterno.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoInterno/list'


        populateValidParams(params)
        def estadoInterno = new EstadoInterno(params)

        assert estadoInterno.save() != null

        params.id = estadoInterno.id

        def model = controller.show()

        assert model.estadoInternoInstance == estadoInterno
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoInterno/list'


        populateValidParams(params)
        def estadoInterno = new EstadoInterno(params)

        assert estadoInterno.save() != null

        params.id = estadoInterno.id

        def model = controller.edit()

        assert model.estadoInternoInstance == estadoInterno
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/estadoInterno/list'

        response.reset()


        populateValidParams(params)
        def estadoInterno = new EstadoInterno(params)

        assert estadoInterno.save() != null

        // test invalid parameters in update
        params.id = estadoInterno.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/estadoInterno/edit"
        assert model.estadoInternoInstance != null

        estadoInterno.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/estadoInterno/show/$estadoInterno.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        estadoInterno.clearErrors()

        populateValidParams(params)
        params.id = estadoInterno.id
        params.version = -1
        controller.update()

        assert view == "/estadoInterno/edit"
        assert model.estadoInternoInstance != null
        assert model.estadoInternoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/estadoInterno/list'

        response.reset()

        populateValidParams(params)
        def estadoInterno = new EstadoInterno(params)

        assert estadoInterno.save() != null
        assert EstadoInterno.count() == 1

        params.id = estadoInterno.id

        controller.delete()

        assert EstadoInterno.count() == 0
        assert EstadoInterno.get(estadoInterno.id) == null
        assert response.redirectedUrl == '/estadoInterno/list'
    }
}
