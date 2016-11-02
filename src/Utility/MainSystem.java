package Utility;

import DriverAndClient.AbstractClient;
import DriverAndClient.AbstractDriver;
import DriverAndClient.Coordinates;
import DriverAndClient.Driver;
import Exceptions.NoAvailableDriverExc;

import java.util.ArrayList;

/**
 * Created by Gianni on 10/9/2016.
 */
public class MainSystem {
    private ArrayList<Driver> driverList;

    public MainSystem(){
        driverList = new ArrayList<>();
    }

    public void addDriver(Driver newDriver){
        driverList.add(newDriver);
    }

    public void transaction(AbstractClient aClient, AbstractDriver aDriver, Coordinates startCoords, Coordinates finishCoords, Invoice anInvoice){
        double cost = 15+getDistance(startCoords, finishCoords)*0.01;
        double uberBalance = cost*0.10;
        double driverBalance = cost*0.90;
        double clientBalance = cost*(-1);
        aDriver.addFunds(driverBalance);
        aClient.spend(cost);

        Transaction driverTransaction = new Transaction("Trip", "Driver charges money", aDriver.getCreditCard().getCreditCardNumber(), "A description", driverBalance);
        Transaction uberTransaction = new Transaction("Trip", "Uber charges commission", aClient.getCreditCardNumber(), "A description", uberBalance);
        Transaction clientTransaction = new Transaction("Trip", "Client pays for service", aClient.getCreditCardNumber(), "A description", clientBalance);

        anInvoice.add(driverTransaction);
        anInvoice.add(uberTransaction);
        anInvoice.add(clientTransaction);

    }

    public double calculateCost(Coordinates start, Coordinates finish){
        double distance = getDistance(start, finish);
        return 15 + 0.01*distance;
    }

    public double getDistance(Coordinates startCoords, Coordinates finishCoords){
        return Math.sqrt((finishCoords.getValueX() - startCoords.getValueX())+(finishCoords.getValueY() - startCoords.getValueY()));
    }

    public Driver chooseDriver(Coordinates startCoordinates,Coordinates finishCoords, int numberOfPeople){
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
            if (!candidates.get(i2).getAvailability()){
                candidates.remove(i2);
            }else{
                i2++;
            }
        }
        int i3=0;
        while (i3<candidates.size()){
            if (getDistance(startCoordinates, candidates.get(i3).getCoordinates())>10000){
                candidates.remove(i3);
            }else{
                i3++;
            }
        }
        int i4=0;
        while (i4<candidates.size()){
            Driver bestCandidate = getLowestImgCost(candidates, startCoordinates);
            if (bestCandidate.requestDriver(finishCoords)){
                i4++;
                return bestCandidate;
            }else{
                candidates.remove(bestCandidate);
            }
        }
        throw new NoAvailableDriverExc();
    }

    private Driver getLowestImgCost(ArrayList<Driver> candidates, Coordinates startCoordinates){
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

    public ArrayList<Driver> getDriverList() {
        return driverList;
    }
}
