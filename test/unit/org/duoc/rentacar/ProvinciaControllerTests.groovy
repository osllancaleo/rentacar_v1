package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(ProvinciaController)
@Mock(Provincia)
class ProvinciaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/provincia/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.provinciaInstanceList.size() == 0
        assert model.provinciaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.provinciaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.provinciaInstance != null
        assert view == '/provincia/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/provincia/show/1'
        assert controller.flash.message != null
        assert Provincia.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/provincia/list'


        populateValidParams(params)
        def provincia = new Provincia(params)

        assert provincia.save() != null

        params.id = provincia.id

        def model = controller.show()

        assert model.provinciaInstance == provincia
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/provincia/list'


        populateValidParams(params)
        def provincia = new Provincia(params)

        assert provincia.save() != null

        params.id = provincia.id

        def model = controller.edit()

        assert model.provinciaInstance == provincia
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/provincia/list'

        response.reset()


        populateValidParams(params)
        def provincia = new Provincia(params)

        assert provincia.save() != null

        // test invalid parameters in update
        params.id = provincia.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/provincia/edit"
        assert model.provinciaInstance != null

        provincia.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/provincia/show/$provincia.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        provincia.clearErrors()

        populateValidParams(params)
        params.id = provincia.id
        params.version = -1
        controller.update()

        assert view == "/provincia/edit"
        assert model.provinciaInstance != null
        assert model.provinciaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/provincia/list'

        response.reset()

        populateValidParams(params)
        def provincia = new Provincia(params)

        assert provincia.save() != null
        assert Provincia.count() == 1

        params.id = provincia.id

        controller.delete()

        assert Provincia.count() == 0
        assert Provincia.get(provincia.id) == null
        assert response.redirectedUrl == '/provincia/list'
    }
}
