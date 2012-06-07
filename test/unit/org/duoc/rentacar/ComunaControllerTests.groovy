package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(ComunaController)
@Mock(Comuna)
class ComunaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/comuna/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.comunaInstanceList.size() == 0
        assert model.comunaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.comunaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.comunaInstance != null
        assert view == '/comuna/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/comuna/show/1'
        assert controller.flash.message != null
        assert Comuna.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/comuna/list'


        populateValidParams(params)
        def comuna = new Comuna(params)

        assert comuna.save() != null

        params.id = comuna.id

        def model = controller.show()

        assert model.comunaInstance == comuna
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/comuna/list'


        populateValidParams(params)
        def comuna = new Comuna(params)

        assert comuna.save() != null

        params.id = comuna.id

        def model = controller.edit()

        assert model.comunaInstance == comuna
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/comuna/list'

        response.reset()


        populateValidParams(params)
        def comuna = new Comuna(params)

        assert comuna.save() != null

        // test invalid parameters in update
        params.id = comuna.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/comuna/edit"
        assert model.comunaInstance != null

        comuna.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/comuna/show/$comuna.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        comuna.clearErrors()

        populateValidParams(params)
        params.id = comuna.id
        params.version = -1
        controller.update()

        assert view == "/comuna/edit"
        assert model.comunaInstance != null
        assert model.comunaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/comuna/list'

        response.reset()

        populateValidParams(params)
        def comuna = new Comuna(params)

        assert comuna.save() != null
        assert Comuna.count() == 1

        params.id = comuna.id

        controller.delete()

        assert Comuna.count() == 0
        assert Comuna.get(comuna.id) == null
        assert response.redirectedUrl == '/comuna/list'
    }
}
