import grails.todo.security.User
import grails.todo.security.UserRole
import grails.todo.security.Role

class BootStrap {

    def init = { servletContext ->
		def adminRole = Role.findOrSaveByAuthority('ROLE_ADMIN')
		def userRole = Role.findOrSaveByAuthority('ROLE_USER')
		def testUser = User.findOrSaveByUsernameAndPassword('me', 'password')
		def adminUser = User.findOrSaveByUsernameAndPassword('admin', 'admin')

        UserRole.create testUser, userRole
        UserRole.create adminUser, adminRole

        UserRole.withSession {
        	it.flush()
        	it.clear()
        }

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2    	
    }
    def destroy = {
    }
}
