import java.io.IOException;
import java.util.ArrayList;

public class sampleTest {
    public static void main(String[] args) throws IOException {

        dataDriven dd = new dataDriven();
        ArrayList td = dd.getData("addprofile");

        System.out.println(td.get(0));
        System.out.println(td.get(1));
        System.out.println(td.get(2));
        System.out.println(td.get(3));

    }
}
