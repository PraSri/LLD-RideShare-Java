package com.navi.rideshare;

import com.navi.rideshare.controller.RideController;
import com.navi.rideshare.controller.UserController;
import com.navi.rideshare.controller.VehicleController;
import com.navi.rideshare.model.Ride;
import com.navi.rideshare.model.User;
import com.navi.rideshare.model.Vehicle;
import com.navi.rideshare.model.enums.City;
import com.navi.rideshare.model.enums.Gender;
import com.navi.rideshare.service.RideService;
import com.navi.rideshare.service.UserService;
import com.navi.rideshare.service.VehicleService;
import com.navi.rideshare.service.impl.RideServiceImpl;
import com.navi.rideshare.service.impl.UserServiceImpl;
import com.navi.rideshare.service.impl.VehicleServiceImpl;

import java.util.List;

public class Main {

    private final static String MOST_VACANT = "Most Vacant";

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        VehicleService vehicleService = new VehicleServiceImpl();
        RideService rideService = new RideServiceImpl();

        UserController userRegistrationController = new UserController(userService);
        VehicleController vehicleRegistrationController = new VehicleController(vehicleService, userService);
        RideController rideController = new RideController(userService, vehicleService, rideService);


        // Onboard 5 users
        User rohan = userRegistrationController.createUser("Rohan", Gender.MALE, 36);
        Vehicle rohanSwiftVehicle = vehicleRegistrationController.createVehicle(rohan, "Swift", "KA-01-12345");

        User shashank = userRegistrationController.createUser("Shashank", Gender.MALE, 29);
        Vehicle shashankBalenoVehicle = vehicleRegistrationController.createVehicle(shashank, "Baleno", "TS-05-62395");

        User nandini = userRegistrationController.createUser("Nandini", Gender.FEMALE, 29);

        User shipra = userRegistrationController.createUser("Shipra", Gender.FEMALE, 27);
        Vehicle shipraPoloVehicle = vehicleRegistrationController.createVehicle(shipra, "Polo", "KA-05-41491");
        Vehicle shipraScootVehicle = vehicleRegistrationController.createVehicle(shipra, "Scooty", "KA-12-12332");

        User gaurav = userRegistrationController.createUser("Gaurav", Gender.MALE, 29);

        User rahul = userRegistrationController.createUser("Rahul", Gender.MALE, 35);
        Vehicle rahulXUVVehicle = vehicleRegistrationController.createVehicle(shipra, "XUV", "KA-05-1234");

        // Offer 4 rides by 3 Users

        Ride rohanSwiftHydBangRide = rideController.createRide(rohan, rohanSwiftVehicle, City.HYDERABAD, City.BANGALORE, 1);
        Ride shipraScootyBanMysRide = rideController.createRide(shipra, shipraScootVehicle, City.BANGALORE, City.MYSORE, 1);
        Ride shipraPoloBangMysRide = rideController.createRide(shipra, shipraPoloVehicle, City.BANGALORE, City.MYSORE, 2);
        Ride shashankBalenoHydBangRide = rideController.createRide(shashank, shashankBalenoVehicle, City.HYDERABAD, City.BANGALORE, 2);
        Ride rahulXUVHydBanRide = rideController.createRide(rahul, rahulXUVVehicle, City.HYDERABAD, City.BANGALORE, 5);
        Ride rohanSwiftBanPuneRide = rideController.createRide(rohan, shashankBalenoVehicle, City.BANGALORE, City.PUNE, 1);


        rideService.printAllMaps();

        // find rides by 4 users

        Ride nandhiniRideBangMys = rideController.selectRide(nandini, City.BANGALORE, City.MYSORE, 1, MOST_VACANT);
        printRideDetails(nandini, nandhiniRideBangMys);

        Ride gauravRideBangMys = rideController.selectRide(gaurav, City.BANGALORE, City.MYSORE, 1, "ACTIVA");
        printRideDetails(gaurav, gauravRideBangMys);

        Ride shashankRideMumBang = rideController.selectRide(shashank, City.MUMBAI, City.BANGALORE, 1, MOST_VACANT);
        printRideDetails(shashank, shashankRideMumBang);

        Ride rohanHydBangRide = rideController.selectRide(rohan, City.HYDERABAD, City.BANGALORE, 1, "Baleno");
        printRideDetails(rohan, rohanHydBangRide);

        Ride shashankHydBangRide = rideController.selectRide(rohan, City.HYDERABAD, City.BANGALORE, 1, "Polo");
        printRideDetails(rohan, shashankHydBangRide);


        List<Ride> nandiniRidesTaken = rideController.takenRides(nandini);
        List<Ride> nandiniRidesOffered = rideController.offeredRides(nandini);
        System.out.println("Nandini: " + nandiniRidesTaken.size() + "Taken, " + nandiniRidesOffered.size() + " Offered");

        List<Ride> rohanRidesTaken = rideController.takenRides(rohan);
        List<Ride> rohanRidesOffered = rideController.offeredRides(rohan);
        System.out.println("Rohan: " + rohanRidesTaken.size() + "Taken, " + rohanRidesOffered.size() + " Offered");

        List<Ride> shashankRidesTaken = rideController.takenRides(shashank);
        List<Ride> shashankRidesOffered = rideController.offeredRides(shashank);
        System.out.println("Shashank: " + shashankRidesTaken.size() + "Taken, " + shashankRidesOffered.size() + " Offered");

        List<Ride> gauravRidesTaken = rideController.takenRides(gaurav);
        List<Ride> gauravRidesOffered = rideController.offeredRides(gaurav);
        System.out.println("Gaurav: " + gauravRidesTaken.size() + "Taken, " + gauravRidesOffered.size() + " Offered");

        List<Ride> rahulRidesTaken = rideController.takenRides(rahul);
        List<Ride> rahulRidesOffered = rideController.offeredRides(rahul);
        System.out.println("Rahul: " + rahulRidesTaken.size() + "Taken, " + rahulRidesOffered.size() + " Offered");

        List<Ride> shipraRidesTaken = rideController.takenRides(shipra);
        List<Ride> shipraRidesOffered = rideController.offeredRides(shipra);
        System.out.println("Shipra: " + shipraRidesTaken.size() + "Taken, " + shipraRidesOffered.size() + " Offered");

    }

    public static void printRideDetails(User user, Ride ride) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User: ").append(user.getName());
        if (ride == null) {
            stringBuilder.append(". No ride found");
            System.out.println(stringBuilder);
            return;
        }
        stringBuilder.append(". VehicleOwner: ").append(ride.getUser().getName());
        stringBuilder.append(". Vehicle: ").append(ride.getVehicle().getName());
        stringBuilder.append(". Origin: ").append(ride.getOrigin());
        stringBuilder.append(". Destination: ").append(ride.getDestination());
        System.out.println(stringBuilder);
    }
}
