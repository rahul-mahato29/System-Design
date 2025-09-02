package ParkingLot;

import ParkingLot.controllers.ParkingController;
import ParkingLot.entities.*;
import ParkingLot.entities.enums.PaymentMethod;
import ParkingLot.entities.enums.SpotType;
import ParkingLot.repositories.*;
import ParkingLot.services.*;
import ParkingLot.strategies.DefaultSpotAssignmentStrategy;

public class ParkingLot {

    //API-Call-From-Controller : Postman
    public void demo() {
        //todo
        //Pre-Setup

        //step-1 : CreateParkingLot
        //        - add fooler to parkingLot
        //        - CreateParkingSpot
        //        - Add-Parking-Spot-To-fooler


        //step-2 :  Vehicle Entry
        //        - generate ticket
        //        - park vehicle
        //        - update spot space - occupied


        //step-3 : Vehicle Exit
        //      - unpark vehicle
        //      - payment
        //      - update spot space - empty

        //-----------------------------------------------------------

        // Wire repositories
        ParkingLotRepository lotRepo = new ParkingLotRepository();
        FloorRepository floorRepo = new FloorRepository();
        ParkingSpotRepository spotRepo = new ParkingSpotRepository();
        GateRepository gateRepo = new GateRepository();
        TicketRepository ticketRepo = new TicketRepository();
        PaymentRepository paymentRepo = new PaymentRepository();
        ReceiptRepository receiptRepo = new ReceiptRepository();


        // Services
        ParkingLotService lotService = new ParkingLotService(lotRepo, floorRepo, spotRepo);
        ParkingSpotManager spotManager = new ParkingSpotManager(lotRepo, new DefaultSpotAssignmentStrategy());
        TicketService ticketService = new TicketService(ticketRepo);
        PaymentService paymentService = new PaymentService(paymentRepo, receiptRepo);
        GateService gateService = new GateService(gateRepo, spotManager, ticketService, paymentService, spotRepo);


        // Controller
        ParkingController controller = new ParkingController(lotService, gateService, gateRepo);


        // Pre-Setup
        controller.createLot(1);
        controller.addFloor(0);
        controller.addSpot(101, SpotType.TWO_WHEELER, 0);
        controller.addSpot(102, SpotType.FOUR_WHEELER, 0);
        controller.addEntryGate(1);
        controller.addExitGate(2);


        // Step-2 Vehicle Entry
        Vehicle bike = new Bike("BR-09-1111");
        Ticket t1 = controller.enter(bike, 1);
        System.out.println("Ticket generated: " + t1.getId() + " spot:" + t1.getSpotId());


        Vehicle car = new Car("BR-09-2222");
        Ticket t2 = controller.enter(car, 1);
        System.out.println("Ticket generated: " + t2.getId() + " spot:" + t2.getSpotId());


        // Step-3 Vehicle Exit
        Receipt r1 = controller.exit(t1.getId(), 2, PaymentMethod.UPI);
        System.out.println("Receipt: " + r1.getId() + " amount:" + r1.getAmount());
    }
}
