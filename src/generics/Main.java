package generics;

public class Main {
    public static void main(String[] args) {
        genericListUse();
    }

    public static void utils(){
        var user1 = new User(10, "e");
        var user2 = new User(20, "d");


        var max = Utils.max(user1.getName(), user2.getName());
        System.out.println(max);
    }

    public static void comparableUser(){
        var user1 = new User(10,"e");
        var user2 = new User(20,"s");
        if(user1.compareTo(user2) < 0){
            System.out.println("user1 < user2");
        } else if(user1.compareTo(user2) == 0){
            System.out.println("user1 == user2");
        } else {
            System.out.println("user1 > user2");
        }
    }

    public static void genericListUse(){
        //var numbers = new GenericArray<Integer>();
        var numbers = new GenericArrayList<Integer>();
        numbers.add(1); // Boxing
        numbers.add(2); // Boxing
        numbers.add(3); // Boxing

        for(var item : numbers){
            System.out.println(item);
        }
        //int number = numbers.get(0); // Unboxing
    }
}


