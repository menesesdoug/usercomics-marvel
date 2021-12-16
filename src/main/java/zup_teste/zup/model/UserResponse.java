package zup_teste.zup.model;

public class UserResponse {
    private Object user;
    //private UserDTOComics userDTOComics;
    private String message;

    public UserResponse() {
    }

    
    public UserResponse(Object user, String message) {
        this.user = user;
        this.message = message;
    }

    public Object getUser() {
        return this.user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

}
