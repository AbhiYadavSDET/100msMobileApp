package Insurance.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "address",
        "nomineeName",
        "fullName",
        "nomineeAge",
        "pincode",
        "dob",
        "nomineeRelationship",
        "policyId",
        "email",
        "phone",
        "state",
        "gender"
})
public class PolicyDetailsDto {

    @JsonProperty("address")
    private String address;
    @JsonProperty("nomineeName")
    private String nomineeName;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("nomineeAge")
    private String nomineeAge;
    @JsonProperty("pincode")
    private String pincode;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("nomineeRelationship")
    private String nomineeRelationship;
    @JsonProperty("policyId")
    private String policyId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("state")
    private String state;
    @JsonProperty("gender")
    private String gender;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("nomineeName")
    public String getNomineeName() {
        return nomineeName;
    }

    @JsonProperty("nomineeName")
    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("nomineeAge")
    public String getNomineeAge() {
        return nomineeAge;
    }

    @JsonProperty("nomineeAge")
    public void setNomineeAge(String nomineeAge) {
        this.nomineeAge = nomineeAge;
    }

    @JsonProperty("pincode")
    public String getPincode() {
        return pincode;
    }

    @JsonProperty("pincode")
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @JsonProperty("dob")
    public String getDob() {
        return dob;
    }

    @JsonProperty("dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @JsonProperty("nomineeRelationship")
    public String getNomineeRelationship() {
        return nomineeRelationship;
    }

    @JsonProperty("nomineeRelationship")
    public void setNomineeRelationship(String nomineeRelationship) {
        this.nomineeRelationship = nomineeRelationship;
    }

    @JsonProperty("policyId")
    public String getPolicyId() {
        return policyId;
    }

    @JsonProperty("policyId")
    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}