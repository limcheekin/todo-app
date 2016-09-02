package grails.todo.security

class AuthenticationToken {
    String tokenValue
    String username

    static mapping = {
        version false
    }
    
    static constraints = {
    }
}
