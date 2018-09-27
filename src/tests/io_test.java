package tests;

import java.io.*;
import java.util.HashSet;

public class io_test implements Serializable{
//    String str=null;
//    String str2=null;
    HashSet<Double> set  = new HashSet<>();

    public io_test() {
        System.out.println("IN CTOR");
        set  = new HashSet<>();
        for (int i=0; i < 30; i++)
            set.add(i*-0.3);
    }

    public HashSet<Double> getSet(){
        return set;
    }

    public static void main (String[] args) throws IOException, ClassNotFoundException {
        System.out.println("MAIN");
        HashSet<Double> nums = new HashSet<>();
        for (int i=0; i < 30; i++)
            nums.add(i*-1.1);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Private\\learning_curve\\tmp\\io_test.data"));
        objectOutputStream.writeObject(nums);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Private\\learning_curve\\tmp\\io_test.data"));

        Object read_obj = objectInputStream.readObject();
        HashSet<Double> read = (HashSet<Double>) read_obj;
        System.out.println(read);



        objectInputStream.close();
    }
}
