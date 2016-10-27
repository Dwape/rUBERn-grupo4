
public class rUBERnMenu extends Formulary{

    private String title = "rUBERn Menu";

    public rUBERnMenu (MainData data){
        show();
        int result = Scanner.getInt("Which option would you like to execute: ");

        switch (result){
            case 1:
                data.getrUBERnSystem().addDriver(createDriver());
                new rUBERnMenu(data);
                break;
            case 2:
                data.getInvoice().print();
                new rUBERnMenu(data);
                break;
            case 3:
                new MainMenu(data);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    private Driver createDriver(){
        String name = Scanner.getString("Please enter your name: ");

        boolean loop = true;
        Category category;
        category = new Premium();
        while (loop) {
            System.out.println("1.Premium");
            System.out.println("2.Standard");
            System.out.println("3.Basic");
            int numberCategory = Scanner.getInt("Choose a category for your car: ");
            switch (numberCategory) {
                case 1:
                    category = new Premium();
                    loop = false;
                    break;
                case 2:
                    category = new Standard();
                    loop = false;
                    break;
                case 3:
                    category = new Basic();
                    loop = false;
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        }
        int spaceCar = Scanner.getInt("Car capacity for passenger: ");
        System.out.println("Please enter your coordinates");
        long coordinateX = Scanner.getLong("Enter your X coordinate: ");
        long coordinateY = Scanner.getLong("Enter your y coordinate: ");
        long creditCard = Scanner.getLong("Enter your credit card number: ");
        Coordinates coordinates = new Coordinates(coordinateX,coordinateY);
        System.out.println();
        Car car = new Car(spaceCar,category,coordinates);
        System.out.println("Driver registered successfully");
        return new Driver(car,name, creditCard);
    }

   /* private Schedule createSchedule() {
        Schedule schedule = new Schedule();
        String[] daysOfTheWeek = new String[7];
        daysOfTheWeek[0] = "monday";
        daysOfTheWeek[1] = "tuesday";
        daysOfTheWeek[2] = "wednesday";
        daysOfTheWeek[3] = "thursday";
        daysOfTheWeek[4] = "friday";
        daysOfTheWeek[5] = "saturday";
        daysOfTheWeek[6] = "sunday";
        int i = 0;
        System.out.println("Please enter your working hours");
        while (i < 7) {
            try {
                String iDay = Scanner.getString("Enter your starting hour on " + daysOfTheWeek[i] + " (HH:mm): ");
                String fDay = Scanner.getString("Enter your finish hour on " + daysOfTheWeek[i] + " (HH:mm): ");
                schedule.setHoursPerDay(iDay, fDay, daysOfTheWeek[i]);
                i++;
            } catch (IllegalArgumentException exc) {
                System.out.println("Please enter the time in the following format (HH:mm)");
            }
        }
        return schedule;
    }*/

    public String getTitle(){
        return title;
    }

    public void displayContent(){
        System.out.println("1.Register Driver");
        System.out.println("2.Print Invoice");
        System.out.println("3.Back");
        System.out.println("4.Exit");
    }
}
