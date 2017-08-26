public class SingletonClass {

    private static SingletonClass myObj;

    private SingletonClass() {}

    public static SingletonClass getInstance() {
        if (myObj == null) {
            myObj = new SingletonClass();
        }
        System.out.println(myObj);
        return myObj;

    }

    public static void main(String a[]) {
        SingletonClass st = SingletonClass.getInstance();
        st.getSomeThing();
    }

    public void getSomeThing() {
        System.out.println("I am here....");
    }
}