import Exceptions.NoAvailableDriverExc;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by Gianni on 10/9/2016.
 */
public class MainSystem {
    ArrayList<Driver> driverList;

    public MainSystem(){
        driverList = new ArrayList<>();
    }

    public void Transaction(Client aClient, Driver aDriver, Coordinates startCoords, Coordinates finishCoords, Invoice anInvoice){
        double cost = getCost(startCoords, finishCoords)*0.01;
        double uberBalance = cost*0.10;
        double driverBalance = cost*0.90;
        double clientBalance = cost*(-1);
        aDriver.addFunds(driverBalance);
        aClient.spend(cost);
        for (int i = 0;i<3;i++){
            if (i==0){
                anInvoice.addTipoOper("Driver charges money");
                anInvoice.addMonto(driverBalance);
            }else if(i==1){
                anInvoice.addTipoOper("Uber charges comision");
                anInvoice.addMonto(uberBalance);
            }else if(i==2){
                anInvoice.addTipoOper("Client pays for service");
                anInvoice.addMonto(clientBalance);
            }
            anInvoice.addIdentificador("Viaje");
            anInvoice.addFecha(DateTime.now());
            anInvoice.addDescripcion("A description");
            anInvoice.addTarjeta(aClient.getCreditCardNumber());
        }

    }

    public double getCost(Coordinates startCoords, Coordinates finishCoords){
        return Math.sqrt((finishCoords.getValueX() - startCoords.getValueX())+(finishCoords.getValueY() - startCoords.getValueY()));
    }

    public Driver chooseDriver(Coordinates startCoordinates, Coordinates finishCoordinates, int numberOfPeople){
        ArrayList<Driver> candidates = new ArrayList<>();
        for (int i=0; i<driverList.size(); i++){
            candidates.add(driverList.get(i));
        }
        for (int i=0; i<candidates.size(); i++){
            if (candidates.get(i).getCar().getSpace() < numberOfPeople){
                candidates.remove(i);
            }
        }
        for (int i=0; i<candidates.size(); i++){
            if (!candidates.get(i).checkAvailability()){
                candidates.remove(i);
            }
        }
        int numberOfCandidates = candidates.size();
        for (int i=0; i<numberOfCandidates; i++){
            Driver bestCandidate = calculateDistance(candidates, startCoordinates);
            if (bestCandidate.requestDriver() && candidates.contains(bestCandidate)){
                return bestCandidate;
            } else{
                candidates.remove(bestCandidate);
            }
        }
        throw new NoAvailableDriverExc();
    }

    public Driver calculateDistance(ArrayList<Driver> candidates, Coordinates startCoordinates){
        double distance = 0;
        Driver closestDriver = candidates.get(0);
        for (int i=0; i< candidates.size(); i++){
            double currentDriversDistance;
            long driverX = candidates.get(i).getCoordinates().getValueX();
            long driverY = candidates.get(i).getCoordinates().getValueY();
            long startX = startCoordinates.getValueX();
            long startY = startCoordinates.getValueY();
            currentDriversDistance = Math.sqrt(Math.pow(driverX-startX, 2) + Math.pow(driverY-startY, 2));
            if (currentDriversDistance < distance){
                closestDriver = candidates.get(i);
            }
        }
        return closestDriver;
    }
}
