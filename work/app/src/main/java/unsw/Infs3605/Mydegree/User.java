package unsw.Infs3605.Mydegree;

public class User {

    private static int id;
    private static String username;
    private static String password;
    private static int points;

    public User(){

    }
    public User(int id, String username, String password, int points){
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

