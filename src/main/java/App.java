/**
 * Created by Przemek on 2016-07-19.
 */
public class App {

    String test;

    public App(){
        test = "test";
    }

    public static void main(String[] args){
        App app = new App();
        app.changeString("test2");
    }

    public void changeString(String s){
        this.test = s;
    }
}
