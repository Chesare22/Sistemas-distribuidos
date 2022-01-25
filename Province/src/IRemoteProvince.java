import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IRemoteProvince extends Remote {
    int save(Province p) throws RemoteException;

    int update(Province p) throws RemoteException;

    int delete(Province p) throws RemoteException;

    void deleteAll() throws RemoteException;

    ArrayList findAll() throws RemoteException;

    ArrayList findByName(String criteria) throws RemoteException;
}