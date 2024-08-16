package br.edu.ifsuldeminas.mch.sd.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Operations extends Remote {
    Number sum(Number x, Number y) throws RemoteException;

    Number sub(Number x, Number y) throws RemoteException;

    Number mul(Number x, Number y) throws RemoteException;

    Number div(Number x, Number y) throws RemoteException;

    Number sqrt(Number x, int root) throws RemoteException;

    Number pow(Number x, int exponent) throws RemoteException;

    Number percent(Number x, Number y) throws RemoteException;

    Number mod(Number x, Number y) throws RemoteException;

    Number factorial(int x) throws RemoteException;

    List<String> lastOperations(int howMany) throws RemoteException;

    List<String> lastOperations() throws RemoteException;
}