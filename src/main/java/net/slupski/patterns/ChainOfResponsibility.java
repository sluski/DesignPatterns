package net.slupski.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ChainOfResponsibility implements Consumer<Integer>{

   

    @Override
    public void accept(Integer t) {
        Utils.printIndex(t);
        
         var request = new Request("incorrect", "password1");
         var request2 = new Request("admin", "incorrect");
         var request3 = new Request("admin", "password1");
         
         var authService = new AuthService();
         
         authService.logIn(request);
         authService.logIn(request2);
         authService.logIn(request3);
    }
}

class AuthService {
    private BaseHandler handler;
    private Database database;
    
    public AuthService() {
        database = new Database();
        handler = new UsernameHandler(database);
        handler.setNextHandler(new PasswordHandler(database));
    }
    
    boolean logIn(Request request){
        return handler.handle(request);
    }
}

class Request {

    final String username;
    final String password;

    public Request(String username, String password) {
        this.username = username;
        this.password = password;
    }

}

interface Handler {

    boolean handle(Request request);
}

abstract class BaseHandler implements Handler {

    Handler next;

    Handler setNextHandler(Handler handler) {
        next = handler;
        return next;
    }

    boolean handleNext(Request request) {
        if (next == null) {
            return true;
        }
        return next.handle(request);
    }
}

class UsernameHandler extends BaseHandler {

    private final Database database;

    public UsernameHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(Request request) {
        if (!database.isValidUsername(request.username)) {
            System.out.println("Username is invalid");
            return false;
        }
        return handleNext(request);
    }

}

class PasswordHandler extends BaseHandler {

    private final Database database;

    public PasswordHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(Request request) {
        if (!database.isValidPassword(request.username, request.password)) {
            System.out.println("Password is invalid");
            return false;
        }
        System.out.println("Auth successful");
        return handleNext(request);
    }

}

class Database {

    private final Map<String, String> users;

    public Database() {
        users = new HashMap<>();
        users.put("admin", "password1");
        users.put("user", "password2");
    }

    public boolean isValidUsername(String username) {
        return users.containsKey(username);
    }

    public boolean isValidPassword(String username, String password) {
        return users.get(username).equals(password);
    }
}
