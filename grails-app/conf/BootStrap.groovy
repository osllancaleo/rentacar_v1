import org.duoc.rentacar.Motor
import org.duoc.rentacar.TipoVehiculo
import org.duoc.rentacar.EstadoInterno
import org.duoc.rentacar.Region
import org.duoc.rentacar.Provincia
import org.duoc.rentacar.Comuna
import org.duoc.rentacar.Color
import org.duoc.rentacar.EstadoArriendo
import org.duoc.rentacar.EstadoVehiculo
import org.duoc.rentacar.Requestmap
class BootStrap {

    def init = { servletContext ->
        def rm = Requestmap.findByUrl('/login/**')?: new Requestmap(url:'/login/**',configAttribute:'IS_AUTHENTICATED_ANONYMOUSLY').save()
        def rm1 = Requestmap.findByUrl('/login/**')?:new Requestmap(url:'/logout/**',configAttribute:'IS_AUTHENTICATED_ANONYMOUSLY').save()
        //def rm2 = Requestmap.findByUrl('/**')?:new Requestmap(url:'/**',configAttribute:'ROLE_SUPERADMIN,ROLE_ADMIN,ROLE_AGENT').save()
       
        
        
        
        if (Motor.getAll().size() < 1){
            insertMotor()
        }
        if (TipoVehiculo.getAll().size() < 1){
            insertTipoVehiculo()
        }
        if (EstadoInterno.getAll().size() <1 ){
            insertEstadoInterno()
        }
        if (Region.getAll().size() <1 ){
            insertRegion()
        }
        if (Color.getAll().size() <1){
            insertColor()
        }
        if (EstadoArriendo.getAll().size() <1){
            insertEstadoArriendo()
        }
        if (EstadoVehiculo.getAll().size() <1){
            insertEstadoVehiculo()
        }

    }
    def destroy = {
    }
    def insertMotor(){
        println "Cargando Motor................................................."
        def motor1 = new Motor(nombre:"1000cc",id:1).save()
        def motor2 = new Motor(nombre:"1100cc",id:2).save()
        def motor3 = new Motor(nombre:"1200cc",id:3).save()
        def motor4 = new Motor(nombre:"1300cc",id:4).save()
        def motor5 = new Motor(nombre:"1400cc",id:5).save()
        def motor6 = new Motor(nombre:"1500cc",id:6).save()
        def motor7 = new Motor(nombre:"1600cc",id:7).save()
        def motor8 = new Motor(nombre:"1700cc",id:8).save()
        def motor9 = new Motor(nombre:"1800cc",id:9).save()
        def motor10 = new Motor(nombre:"1900cc",id:10).save()
        def motor11 = new Motor(nombre:"2000cc",id:11).save()
        def motor12 = new Motor(nombre:"2100cc",id:12).save()
        def motor13 = new Motor(nombre:"2200cc",id:13).save()
        def motor14 = new Motor(nombre:"2300cc",id:14).save()
        def motor15 = new Motor(nombre:"2400cc",id:15).save()
        def motor16 = new Motor(nombre:"2500cc",id:16).save()
        def motor17 = new Motor(nombre:"2600cc",id:17).save()
        def motor18 = new Motor(nombre:"2700cc",id:18).save()
    }
    def insertTipoVehiculo(){
        println "Cargando Tipo Vehiculo........................................."
        def tv1 = new TipoVehiculo(nombre:"Automóvil",id:1).save()
        def tv2 = new TipoVehiculo(nombre:"Camioneta",id:2).save()
        def tv3 = new TipoVehiculo(nombre:"Todo Terreno",id:3).save()
        def tv4 = new TipoVehiculo(nombre:"Mini Bus",id:4).save()
        def tv5 = new TipoVehiculo(nombre:"Van de lujo",id:5).save()
        def tv6 = new TipoVehiculo(nombre:"Furgón",id:6).save()
        def tv7 = new TipoVehiculo(nombre:"Camión",id:7).save()
    }
    def insertEstadoInterno(){
        println "Cargando Estado Interno........................................"
        def ei1 = new EstadoInterno(nombre:"Habilitado",id:1).save()
        def ei2 = new EstadoInterno(nombre:"Deshabilitado",id:2).save()
    }
    def insertEstadoVehiculo(){
        println "Cargando Estado Vehiculo........................................"
        def ei1 = new EstadoVehiculo(nombre:"Disponible",id:1).save()
        def ei2 = new EstadoVehiculo(nombre:"Arrendado",id:2).save()
        
    }
    def insertEstadoArriendo(){
        println "Cargando Estado Arriendo........................................"
        def ei1 = new EstadoArriendo(nombre:"Arrendado",id:1).save()
        def ei2 = new EstadoArriendo(nombre:"Devuelto",id:2).save()
    }
    def insertRegion(){
        println "Cargando Regiones-Provincias-Comunas..........................."
        def ei1 = new Region(id:1,nombre:'Tarapacá').save()
        def ei2 = new Region(id:2,nombre: 'Antofagasta').save()
        def ei3 = new Region(id:3,nombre: 'Atacama').save()
        def ei4 = new Region(id:4,nombre: 'Coquimbo').save()
        def ei5 = new Region(id:5,nombre: 'Valparaíso').save()
        def ei6 = new Region(id:6,nombre: 'Región del Libertador Gral. Bernardo O’Higgins').save()
        def ei7 = new Region(id:7,nombre: 'Región del Maule').save()
        def ei8 = new Region(id:8,nombre: 'Región del Biobío').save()
        def ei9 = new Region(id:9,nombre: 'Región de la Araucanía').save()
        def ei10 = new Region(id:10,nombre: 'Región de Los Lagos').save()
        def ei12 = new Region(id:11,nombre: 'Región Aisén del Gral. Carlos Ibáñez del Campo').save()
        def ei13 = new Region(id:12,nombre: 'Región de Magallanes y de la Antártica Chilena').save()
        def ei14 = new Region(id:13,nombre: 'Región Metropolitana de Santiago').save()
        def ei15 = new Region(id:14,nombre: 'Región de Los Ríos').save()
        def ei16 = new Region(id:15,nombre: 'Arica y Parinacota').save()
    }
    def insertColor(){
        println "Cargando Colores..........................."
        def c1 = new Color(nombre:"Blanco",id:1).save()
        def c2 = new Color(nombre:"Blanco Perla",id:2).save()
        def c3 = new Color(nombre:"Negro",id:3).save()
        def c4 = new Color(nombre:"Plata",id:4).save()
        def c5 = new Color(nombre:"Grafito",id:5).save()
        def c6 = new Color(nombre:"Gris",id:6).save()
        def c7 = new Color(nombre:"Azul",id:7).save()
        def c8 = new Color(nombre:"Rojo",id:8).save()
        def c9 = new Color(nombre:"Amarillo",id:9).save()
        def c10 = new Color(nombre:"Verde",id:10).save()
        def c11 = new Color(nombre:"Cafe",id:11).save()
    }
}
