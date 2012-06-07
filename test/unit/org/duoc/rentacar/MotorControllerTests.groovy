package org.duoc.rentacar



import org.junit.*
import grails.test.mixin.*

@TestFor(MotorController)
@Mock(Motor)
class MotorControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/motor/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.motorInstanceList.size() == 0
        assert model.motorInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.motorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.motorInstance != null
        assert view == '/motor/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/motor/show/1'
        assert controller.flash.message != null
        assert Motor.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/motor/list'


        populateValidParams(params)
        def motor = new Motor(params)

        assert motor.save() != null

        params.id = motor.id

        def model = controller.show()

        assert model.motorInstance == motor
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/motor/list'


        populateValidParams(params)
        def motor = new Motor(params)

        assert motor.save() != null

        params.id = motor.id

        def model = controller.edit()

        assert model.motorInstance == motor
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/motor/list'

        response.reset()


        populateValidParams(params)
        def motor = new Motor(params)

        assert motor.save() != null

        // test invalid parameters in update
        params.id = motor.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/motor/edit"
        assert model.motorInstance != null

        motor.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/motor/show/$motor.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        motor.clearErrors()

        populateValidParams(params)
        params.id = motor.id
        params.version = -1
        controller.update()

        assert view == "/motor/edit"
        assert model.motorInstance != null
        assert model.motorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/motor/list'

        response.reset()

        populateValidParams(params)
        def motor = new Motor(params)

        assert motor.save() != null
        assert Motor.count() == 1

        params.id = motor.id

        controller.delete()

        assert Motor.count() == 0
        assert Motor.get(motor.id) == null
        assert response.redirectedUrl == '/motor/list'
    }
}
