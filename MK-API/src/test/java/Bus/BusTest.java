package Bus;

import Bus.Api.*;
import Bus.Helper.BusAvailabilityHelper;
import Bus.Helper.FetchCouponsHelper;
import Bus.Models.RequestDto.Availability.AvailabilityRequestDto;
import Bus.Models.RequestDto.Booking.BookingRequestDto;
import Bus.Models.RequestDto.BusAvailability.BusAvailabilityRequestDto;
import Bus.Models.RequestDto.Passengers.Passenger;
import Bus.Models.RequestDto.Passengers.PassengersRequestDto;
import Bus.Models.RequestDto.Passengers.SeatDetail;
import Bus.Models.ResponseDto.BusAvailability.SearchResult;
import Utils.Log;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BusTest {

    Response response;


    @Test(groups = "policyPurchase", priority = 1)
    public void Test01_verify_fetch_coupons_normaluser() {

        FetchCoupons fetchCoupons = new FetchCoupons();


        response = fetchCoupons.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        FetchCouponsHelper fetchCouponsHelper = new FetchCouponsHelper(response.getBody().asString());
        fetchCouponsHelper.verifySuccessResponse();
        fetchCouponsHelper.verifyNoOfCouponCodes();


    }

    @Test(groups = "policyPurchase", priority = 2)
    public void Test02_verify_bus_availability() {

        String sourceId = "5136";
        String destId = "7210";
        String doj = "2019-03-20";


        BusAvailabilityRequestDto busAvailabilityRequestDto = new BusAvailabilityRequestDto();
        busAvailabilityRequestDto.setSourceId(sourceId);
        busAvailabilityRequestDto.setDestId(destId);
        busAvailabilityRequestDto.setDoj(doj);


        BusAvailablity busAvailablity = new BusAvailablity(busAvailabilityRequestDto);
        response = busAvailablity.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        BusAvailabilityHelper busAvailabilityHelper = new BusAvailabilityHelper(response.getBody().asString());
        busAvailabilityHelper.setXMScope(response.getHeaders().getValue("X-MScope"));

        SearchResult searchResult = busAvailabilityHelper.searchForBus("Das & Das Travels");

        busAvailabilityHelper.setScheduleId(searchResult);
        busAvailabilityHelper.verifyBusDetails(searchResult, 2, "Das & Das Travels", "Leyland A/C Seater/Sleeper Maharaja push back (2+2)", "11:50", "17:30", "05:40");


    }

    @Test(groups = "policyPurchase", priority = 3)
    public void Test03_verify_availability() {

        String sourceId = "5136";
        String destId = "7210";
        String doj = "2019-03-20";


        BusAvailabilityRequestDto busAvailabilityRequestDto = new BusAvailabilityRequestDto();
        busAvailabilityRequestDto.setSourceId(sourceId);
        busAvailabilityRequestDto.setDestId(destId);
        busAvailabilityRequestDto.setDoj(doj);


        BusAvailablity busAvailablity = new BusAvailablity(busAvailabilityRequestDto);
        response = busAvailablity.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        BusAvailabilityHelper busAvailabilityHelper = new BusAvailabilityHelper(response.getBody().asString());
        busAvailabilityHelper.setXMScope(response.getHeaders().getValue("X-MScope"));

        SearchResult searchResult = busAvailabilityHelper.searchForBus("Das & Das Travels");

        busAvailabilityHelper.setScheduleId(searchResult);

        AvailabilityRequestDto availabilityRequestDto = new AvailabilityRequestDto();
        availabilityRequestDto.setScheduleId(String.valueOf(BusAvailabilityHelper.map.get("scheduleId")));


        Availability availability = new Availability(availabilityRequestDto, String.valueOf(BusAvailabilityHelper.map.get("XMScope")));


        response = availability.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

//        AvailabilityHelper availabilityHelper = new AvailabilityHelper(response.getBody().asString());
//        availabilityHelper.verifySuccessResponse();


    }

    @Test(groups = "policyPurchase", priority = 4)
    public void Test04_verify_booking_passengers() {

        String sourceId = "5136";
        String destId = "7210";
        String doj = "2019-03-20";


        BusAvailabilityRequestDto busAvailabilityRequestDto = new BusAvailabilityRequestDto();
        busAvailabilityRequestDto.setSourceId(sourceId);
        busAvailabilityRequestDto.setDestId(destId);
        busAvailabilityRequestDto.setDoj(doj);


        BusAvailablity busAvailablity = new BusAvailablity(busAvailabilityRequestDto);
        response = busAvailablity.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        BusAvailabilityHelper busAvailabilityHelper = new BusAvailabilityHelper(response.getBody().asString());
        busAvailabilityHelper.setXMScope(response.getHeaders().getValue("X-MScope"));

        SearchResult searchResult = busAvailabilityHelper.searchForBus("Das & Das Travels");

        busAvailabilityHelper.setScheduleId(searchResult);

        AvailabilityRequestDto availabilityRequestDto = new AvailabilityRequestDto();
        availabilityRequestDto.setScheduleId(String.valueOf(BusAvailabilityHelper.map.get("scheduleId")));


        int board_point_id = 41519;
        int drop_point_id = 41532;
        String emergency_contact_no = "";
        int baseFare = 330;
        String coupon_code = "";
        Boolean is_return = false;
        String cell_no = "9953138474";

        // Passenger Details
        int age = 25;
        String gender = "M";
        String id_card_issuer = "dummy";
        String id_card_no = "dummy";
        String id_card_type = "dummy";
        String name = "Mayank Suneja";
        Boolean primary = true;
        String seat = "3";
        String title = "Mr.";

        int schedule_id = 10;
        Boolean split_pay = false;
        int totalFare = 330;

        // Seat Details
        Boolean available = true;
        int fare = 330;
        Boolean isDisabledInFilter = false;
        Boolean isSelected = true;
        Boolean isSleeper = false;
        String reserved_fzr = "N";
        String seat_no = "3";
        String type = "SS";


        PassengersRequestDto passengersRequestDto = new PassengersRequestDto();


        SeatDetail seatDetail = new SeatDetail();
        seatDetail.setAvailable(available);
        seatDetail.setFare(330);
        seatDetail.setIsDisabledInFilter(isDisabledInFilter);
        seatDetail.setIsSelected(isSelected);
        seatDetail.setIsSleeper(isSleeper);
        seatDetail.setReservedFor(reserved_fzr);
        seatDetail.setSeatNo(seat_no);
        seatDetail.setType(type);


        Passenger passenger = new Passenger();
        passenger.setAge(age);
        passenger.setGender(gender);
        passenger.setIdCardIssuer(id_card_issuer);
        passenger.setIdCardNo(id_card_no);
        passenger.setIdCardType(id_card_type);
        passenger.setName(name);
        passenger.setPrimary(primary);
        passenger.setSeat(seat);
        passenger.setSeatDetail(seatDetail);
        passenger.setTitle(title);


        passengersRequestDto.setBaseFare(baseFare);
        passengersRequestDto.setBoardPointId(board_point_id);
        passengersRequestDto.setDropPointId(drop_point_id);
        passengersRequestDto.setCellNo(cell_no);
        passengersRequestDto.setCouponCode(coupon_code);
        passengersRequestDto.setDoj(doj);
        passengersRequestDto.setEmergencyContactNo(emergency_contact_no);
        passengersRequestDto.setIsReturn(is_return);
        List<Passenger> paxList = new ArrayList<Passenger>();
        paxList.add(passenger);
        passengersRequestDto.setPassengers(paxList);
        passengersRequestDto.setScheduleId((Integer) BusAvailabilityHelper.map.get("scheduleId"));
        passengersRequestDto.setSplitPay(split_pay);
        passengersRequestDto.setTotalFare(totalFare);


        Passengers passengers = new Passengers(passengersRequestDto, String.valueOf(BusAvailabilityHelper.map.get("XMScope")));
        response = passengers.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


    }

    @Test(groups = "policyPurchase", priority = 5)
    public void Test05_verify_booking() {

        String sourceId = "5136";
        String destId = "7210";
        String doj = "2019-03-20";


        BusAvailabilityRequestDto busAvailabilityRequestDto = new BusAvailabilityRequestDto();
        busAvailabilityRequestDto.setSourceId(sourceId);
        busAvailabilityRequestDto.setDestId(destId);
        busAvailabilityRequestDto.setDoj(doj);


        BusAvailablity busAvailablity = new BusAvailablity(busAvailabilityRequestDto);
        response = busAvailablity.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        BusAvailabilityHelper busAvailabilityHelper = new BusAvailabilityHelper(response.getBody().asString());
        busAvailabilityHelper.setXMScope(response.getHeaders().getValue("X-MScope"));

        SearchResult searchResult = busAvailabilityHelper.searchForBus("Das & Das Travels");

        busAvailabilityHelper.setScheduleId(searchResult);

        AvailabilityRequestDto availabilityRequestDto = new AvailabilityRequestDto();
        availabilityRequestDto.setScheduleId(String.valueOf(BusAvailabilityHelper.map.get("scheduleId")));

        Availability availability = new Availability(availabilityRequestDto, String.valueOf(BusAvailabilityHelper.map.get("XMScope")));
        response = availability.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        int board_point_id = 41519;
        int drop_point_id = 41532;
        String emergency_contact_no = "";
        int baseFare = 330;
        String coupon_code = "";
        Boolean is_return = false;
        String cell_no = "9953138474";

        // Passenger Details
        int age = 25;
        String gender = "M";
        String id_card_issuer = "dummy";
        String id_card_no = "dummy";
        String id_card_type = "dummy";
        String name = "Mayank Suneja";
        Boolean primary = true;
        String seat = "3";
        String title = "Mr.";

        int schedule_id = 10;
        Boolean split_pay = false;
        int totalFare = 330;

        // Seat Details
        Boolean available = true;
        int fare = 330;
        Boolean isDisabledInFilter = false;
        Boolean isSelected = true;
        Boolean isSleeper = false;
        String reserved_fzr = "N";
        String seat_no = "3";
        String type = "SS";


        BookingRequestDto bookingRequestDto = new BookingRequestDto();


        SeatDetail seatDetail = new SeatDetail();
        seatDetail.setAvailable(available);
        seatDetail.setFare(330);
        seatDetail.setIsDisabledInFilter(isDisabledInFilter);
        seatDetail.setIsSelected(isSelected);
        seatDetail.setIsSleeper(isSleeper);
        seatDetail.setReservedFor(reserved_fzr);
        seatDetail.setSeatNo(seat_no);
        seatDetail.setType(type);


        Passenger passenger = new Passenger();
        passenger.setAge(age);
        passenger.setGender(gender);
        passenger.setIdCardIssuer(id_card_issuer);
        passenger.setIdCardNo(id_card_no);
        passenger.setIdCardType(id_card_type);
        passenger.setName(name);
        passenger.setPrimary(primary);
        passenger.setSeat(seat);
        passenger.setSeatDetail(seatDetail);
        passenger.setTitle(title);


        bookingRequestDto.setBaseFare(330);
        bookingRequestDto.setBoardPointId(41519);
        bookingRequestDto.setDropPointId(41532);
        bookingRequestDto.setCellNo("9953138474");
        bookingRequestDto.setCouponCode("");
        bookingRequestDto.setDoj("2019-03-20");
        bookingRequestDto.setEmergencyContactNo("");
        bookingRequestDto.setIsReturn(false);
        List<Passenger> paxList2 = new ArrayList<Passenger>();
        paxList2.add(passenger);
        bookingRequestDto.setPassengers(paxList2);
        bookingRequestDto.setScheduleId((Integer) BusAvailabilityHelper.map.get("scheduleId"));
        bookingRequestDto.setSplitPay(false);
        bookingRequestDto.setTotalFare(330);

        Log.info("SCOPE : ", String.valueOf(BusAvailabilityHelper.map.get("XMScope")));
        Booking booking = new Booking(bookingRequestDto, String.valueOf(BusAvailabilityHelper.map.get("XMScope")));
        response = booking.execute();
        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


    }

    @Test(groups = "policyPurchase", priority = 6)
    public void Test06_verify_bus_Can_Cancel() {

        String bookingId = "3QPXD0PV1MEU1CMW";

        CanCancel canCancel = new CanCancel(bookingId);
        response = canCancel.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


    }
}
