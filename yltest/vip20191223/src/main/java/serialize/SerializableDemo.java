package serialize;

import java.io.*;

public class SerializableDemo {

    public static void main(String[] args) {
        //serializePerson();
        deserializePerson();

    }

    //序列化
    private static void serializePerson(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("personDemo")));
            PersonDemo personDemo = new PersonDemo();
            personDemo.setAge("20");
            personDemo.setName("张张");
            outputStream.writeObject(personDemo);

            outputStream.close();
            System.out.println("序列化成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //反序列化
    private static void deserializePerson(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("personDemo")));
            PersonDemo personDemo = (PersonDemo) ois.readObject();
            System.out.println(personDemo);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
