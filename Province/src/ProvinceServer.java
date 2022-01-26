import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Server
 */
public class ProvinceServer {
    public static void main(String[] args) {
        try {
            //Create and get reference to rmi registry
            Registry registry = LocateRegistry.createRegistry(1099);

            //Instantiate server object
            var user = args[0];
            var password = args[1];
            ProvinceObject po = new ProvinceObject(user, password);

            //Register server object
            registry.rebind("Province", po);
            System.out.println("ProvinceServer is created!!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}