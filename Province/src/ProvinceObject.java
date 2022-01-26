import java.rmi.server.*;
import java.rmi.*;
import java.util.ArrayList;

/**
 * Server object
 */
public class ProvinceObject extends UnicastRemoteObject implements
        IRemoteProvince {
    private static final long serialVersionUID = 11L;
    private final String user;
    private final String password;

    public ProvinceObject(String user, String password) throws RemoteException {
        super();
        this.user = user;
        this.password = password;
    }

    public int save(Province p) {
        try {
            System.out.println("Invoke save from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return ProvinceRepository.save(p, user, password);
    }

    public int update(Province p) {
        try {
            System.out.println("Invoke update from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return ProvinceRepository.update(p, user, password);
    }

    public int delete(Province p) {
        try {
            System.out.println("Invoke delete from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return ProvinceRepository.delete(p, user, password);
    }

    public void deleteAll() {
        try {
            System.out.println("Invoke deleteAll from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        ProvinceRepository.deleteAll(user, password);
    }

    public ArrayList findAll() {
        try {
            System.out.println("Invoke findAll from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return ProvinceRepository.findAll(user, password);
    }

    public ArrayList findByName(String criteria) {
        try {
            System.out.println("Invoke findByName from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        return ProvinceRepository.findByName(criteria, user, password);
    }
}