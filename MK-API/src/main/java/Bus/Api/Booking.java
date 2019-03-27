package Bus.Api;

import Bus.Models.RequestDto.Booking.BookingRequestDto;
import Utils.BaseApi;
import io.restassured.http.ContentType;

public class Booking extends BaseApi {

    public Booking(BookingRequestDto payload, String xMScope) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "busdevapi.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("api/bookings");
        getSpecBuilder().setRelaxedHTTPSValidation();

        //Set the headers
        getSpecBuilder().addHeader("Authorization", "Z4n5EsJwt4QiTuGqPedbBw==.nflbigpr11qic65k9upi3o86fp");
        getSpecBuilder().addHeader("X-MClient", "3");
        getSpecBuilder().addHeader("X-Device-ID", "2B0D9357EEF4A0BCD6B500AEDDC6AB8427B07949");
        getSpecBuilder().addHeader("X-App-Ver", "680");
        getSpecBuilder().addHeader("X-MScope", xMScope);

        getSpecBuilder().setContentType(ContentType.JSON);

        getSpecBuilder().setBody(payload);
    }
}
