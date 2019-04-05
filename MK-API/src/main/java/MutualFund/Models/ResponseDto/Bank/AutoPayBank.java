package MutualFund.Models.ResponseDto.Bank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "beneficiaryName",
        "accountNumber",
        "ifscCode",
        "bankName",
        "bankLogo",
        "mandateApproved"
})
public class AutoPayBank {

    @JsonProperty("beneficiaryName")
    private String beneficiaryName;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("ifscCode")
    private String ifscCode;
    @JsonProperty("bankName")
    private String bankName;
    @JsonProperty("bankLogo")
    private Object bankLogo;
    @JsonProperty("mandateApproved")
    private Boolean mandateApproved;

    @JsonProperty("beneficiaryName")
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    @JsonProperty("beneficiaryName")
    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    @JsonProperty("accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty("accountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonProperty("ifscCode")
    public String getIfscCode() {
        return ifscCode;
    }

    @JsonProperty("ifscCode")
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    @JsonProperty("bankName")
    public String getBankName() {
        return bankName;
    }

    @JsonProperty("bankName")
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @JsonProperty("bankLogo")
    public Object getBankLogo() {
        return bankLogo;
    }

    @JsonProperty("bankLogo")
    public void setBankLogo(Object bankLogo) {
        this.bankLogo = bankLogo;
    }

    @JsonProperty("mandateApproved")
    public Boolean getMandateApproved() {
        return mandateApproved;
    }

    @JsonProperty("mandateApproved")
    public void setMandateApproved(Boolean mandateApproved) {
        this.mandateApproved = mandateApproved;
    }

}