package codes_new;



public class AnotherOverideTesing extends SuperClass implements someOtherInterface {

    // This method is intended to override the method in the interface
    // but without the @Override annotation, it won't catch the error if the signature doesn't match
    public void getCall() {
        System.out.println("something with number: ");
    }

    public static void main(String[] args) {
        OverideTesting ot = new OverideTesting();
        ot.getCall(); // This will call the method from SuperClass instead of the intended method
    }
}

class SuperClass {
    public void getCall() {
        System.out.println("SuperClass method");
    }
}

interface someOtherInterface {
    void getCall();
}
