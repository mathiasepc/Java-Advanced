package generics;

public class User implements Comparable<User>{
    private int points;
    private String name;

    public User(int points, String name){
        this.points = points;
        this.name = name;
    }

    @Override
    public int compareTo(User other) {
        return this.points - other.points;
    }

    @Override
    public String toString(){
        return "Points= " + points;
    }

    public String getName() {
        return name;
    }
}
