package org.duoc.rentacar

class MenuController {
   /**
	 * Dependency injection for the authenticationTrustResolver.
	 */
	def authenticationTrustResolver

	/**
	 * Dependency injection for the springSecurityService.
	 */
	def springSecurityService
        def authenticateService
    def index() { }

        def ListMenuJson = {
        try{
            SecUser usuario
            if (springSecurityService.isLoggedIn()){
                session.loginId=springSecurityService.principal.id
                usuario = SecUser.get(session.loginId)
            }
            List<SecUserSecRole> listaRoles =  SecUserSecRole.findAllBySecUser(usuario)
            ArrayList<Requestmap> menuPrincipal=new ArrayList();
            for(SecUserSecRole ur: listaRoles){
                println ur.getSecRole()
                SecRole r = ur.getSecRole()
                println r.getAuthority()
                //def ListMenu = Requestmap.list(like: "%"+r.getAuthority()+"%" ,sort:"nombre", order:"asc")
                def ListMenu = Requestmap.findAllByConfigAttributeLike("%"+r.getAuthority()+"%")
                for (Requestmap lq: ListMenu) {
                    int x = menuPrincipal.size()
                    String qm =lq.getNombre().toString()
                    int y=0
                    for (int i= 0 ;i <x;i++){
                        String menu =  menuPrincipal[i].getNombre().toString()
                        println"menu:   "+menu
                        println"remap:   "+qm
                        if (menu.equals(qm)){
                                y=1
                                break
                            }
                    }
                    if (y==0)
                    {
                        menuPrincipal.add(lq)
                        println "--"+lq.getNombre()
                    }
           }
        }
        //println menuPrincipal
        def ListMenu = Requestmap.list(sort:"nombre", order:"asc")//Ciudad.list(sort:"descripcion", order:"asc");
            if(ListMenu.size()>0) {
              render(contentType: "text/json") {
              [listaMenu: menuPrincipal]
            }
            }
        } catch(Exception e) {
          return;
        }
    }
}
