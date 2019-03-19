package Bus.Models.RequestDto.Passengers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "age",
        "gender",
        "id_card_issuer",
        "id_card_no",
        "id_card_type",
        "name",
        "primary",
        "seat",
        "seatDetail",
        "title"
})
public class Passenger {

    @JsonProperty("age")
    private Integer age;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("id_card_issuer")
    private String idCardIssuer;
    @JsonProperty("id_card_no")
    private String idCardNo;
    @JsonProperty("id_card_type")
    private String idCardType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("primary")
    private Boolean primary;
    @JsonProperty("seat")
    private String seat;
    @JsonProperty("seatDetail")
    private SeatDetail seatDetail;
    @JsonProperty("title")
    private String title;

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("id_card_issuer")
    public String getIdCardIssuer() {
        return idCardIssuer;
    }

    @JsonProperty("id_card_issuer")
    public void setIdCardIssuer(String idCardIssuer) {
        this.idCardIssuer = idCardIssuer;
    }

    @JsonProperty("id_card_no")
    public String getIdCardNo() {
        return idCardNo;
    }

    @JsonProperty("id_card_no")
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    @JsonProperty("id_card_type")
    public String getIdCardType() {
        return idCardType;
    }

    @JsonProperty("id_card_type")
    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("primary")
    public Boolean getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @JsonProperty("seat")
    public String getSeat() {
        return seat;
    }

    @JsonProperty("seat")
    public void setSeat(String seat) {
        this.seat = seat;
    }

    @JsonProperty("seatDetail")
    public SeatDetail getSeatDetail() {
        return seatDetail;
    }

    @JsonProperty("seatDetail")
    public void setSeatDetail(SeatDetail seatDetail) {
        this.seatDetail = seatDetail;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

}
