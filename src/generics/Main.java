package generics;

public class Main {
    public static void main(String[] args) {
        var max = Utils.max(new User(10),new User(20));
        System.out.println(max);
    }
}

/*
    var user1 = new User(10);
    var user2 = new User(20);
    if(user1.compareTo(user2) < 0){
      System.out.println("user1 < user2");
    } else if(user1.compareTo(user2) == 0){
      System.out.println("user1 == user2");
    } else {
      System.out.println("user1 > user2");
    }
* */

/*
    var numbers = new GenericList<Integer>();
    numbers.add(1); // Boxing
    int number = numbers.get(0); // Unboxing
* */
