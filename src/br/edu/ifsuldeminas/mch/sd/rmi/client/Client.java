package br.edu.ifsuldeminas.mch.sd.rmi.client;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Client {
    public static void main(String[] args) {
        try {
            Operations calc = (Operations) Naming.lookup("rmi://localhost/CalculatorService");
            
            // Realiza as operações sem imprimir os resultados diretamente
            calc.sum(100, 5);
            calc.sub(1040, 5);
            calc.mul(10, 200);
            calc.div(10.5, 0.1);
            calc.sqrt(16, 2);
            calc.pow(2, 3);
            calc.percent(50, 10);
            calc.mod(10, 3);
            calc.factorial(5);

            // Exibe as últimas operações realizadas
            List<String> lastOperations = calc.lastOperations(9);
            for (String operation : lastOperations) {
                System.out.println(operation);
            }
        } catch (MalformedURLException murle) {
            System.out.println("Erro na URL de acesso ao serviço.");
        } catch (NotBoundException nbe) {
            System.out.println("Erro ao se ligar ao stub remoto. Nome de serviço inválido.");
        } catch (ConnectException re) {
            System.out.println("Erro ao se conectar. Servidor não iniciado.");
        } catch (RemoteException re) {
            System.out.println("Erro na chamada remota.");
            re.printStackTrace();
        }
    }
}