/**
 * Created by yejiapc on 15/12/7.
 */
public class Main {
    public static void main(String[] args){
        Dog dog = new Dog();
        dog.voice("狗","汪汪汪");

        Cat cat = new Cat();
        cat.voice("猫","喵喵喵");

        Sheep sheep = new Sheep();
        sheep.voice("羊", "咩咩咩");
    }
}
