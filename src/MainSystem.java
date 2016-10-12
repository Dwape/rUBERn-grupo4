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

    public void addDriver(Driver newDriver){
        driverList.add(newDriver);
    }

    public void Transaction(Client aClient, Driver aDriver, Coordinates startCoords, Coordinates finishCoords, Invoice anInvoice){
        double cost = 15+getDistance(startCoords, finishCoords)*0.01;
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

    public double calculateCost(Coordinates start, Coordinates finish){
        double distance = getDistance(start, finish);
        return 15 + 0.01*distance;
    }

    public double getDistance(Coordinates startCoords, Coordinates finishCoords){
        return Math.sqrt((finishCoords.getValueX() - startCoords.getValueX())+(finishCoords.getValueY() - startCoords.getValueY()));
    }

    public Driver chooseDriver(Coordinates startCoordinates, Coordinates finishCoordinates, int numberOfPeople){
        ArrayList<Driver> candidates = new ArrayList<>();
        for (int i=0; i<driverList.size(); i++){
            candidates.add(driverList.get(i));
        }
        int i1=0;
        while (i1<candidates.size()){
            if (candidates.get(i1).getCar().getSpace() < numberOfPeople){
                candidates.remove(i1);
            }else{
                i1++;
            }
        }
        int i2=0;
        while (i2<candidates.size()){
            if (!candidates.get(i2).checkAvailability()){
                candidates.remove(i2);
            }else{
                i2++;
            }
        }
        int i3=0;
        while (i3<candidates.size()){
            Driver bestCandidate = getLowestAdCost(candidates, startCoordinates);
            if (bestCandidate.requestDriver()){
                i3++;
                return bestCandidate;
            }else{
                candidates.remove(bestCandidate);
            }
        }
        throw new NoAvailableDriverExc();
    }

    private Driver getClosestDriver(ArrayList<Driver> candidates, Coordinates startCoordinates){
        double distance = getDistance(startCoordinates, candidates.get(0).getCoordinates());
        Driver closestDriver = candidates.get(0);
        for (int i=1; i< candidates.size(); i++){
            double currentDriversDistance;
            currentDriversDistance = getDistance(startCoordinates, candidates.get(i).getCoordinates());
            if (currentDriversDistance < distance){
                closestDriver = candidates.get(i);
                distance = currentDriversDistance;
            }
        }
        return closestDriver;
    }

    private Driver getLowestAdCost(ArrayList<Driver> candidates, Coordinates startCoordinates){
        double initDistanceCost = getDistance(startCoordinates, candidates.get(0).getCoordinates())*0.004;
        double costAd = initDistanceCost+(initDistanceCost*(candidates.get(0).getCar().getaCategory().getExtraPercentageCost()*0.01));
        Driver cheapestDriver = candidates.get(0);
        for (int i=1; i< candidates.size(); i++){
            double currentCostAd;
            double distanceCost = getDistance(startCoordinates, candidates.get(i).getCoordinates())*0.004;
            currentCostAd = distanceCost+(distanceCost*(candidates.get(i).getCar().getaCategory().getExtraPercentageCost()*0.01));
            if (currentCostAd<costAd){
                cheapestDriver = candidates.get(i);
                costAd=currentCostAd;
            }
        }
        return cheapestDriver;
    }
}
