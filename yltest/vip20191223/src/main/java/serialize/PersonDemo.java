package serialize;

import java.io.Serializable;

public class PersonDemo implements Serializable {

    //private static final long serialVersionUID = 5487617517685502736L;

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
