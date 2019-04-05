package MutualFund.Models.ResponseDto.Config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "intro",
        "suggestion",
        "hasPortfolio",
        "showInvestorProfilePage",
        "bankVerification",
        "eNach",
        "showProfileOnStartup",
        "nomineeRelationship",
        "isKYCed",
        "mandateType",
        "pendingMandateCard",
        "occupation",
        "maritalStatus",
        "kycFlowState",
        "sampleKycVideos",
        "kyc",
        "offlineKycStoreLink",
        "fullSellAmountPercent",
        "ipvVideoDuration",
        "ipvVideoSize",
        "showInvestorProfilePageV2",
        "faqUrl",
        "homeList",
        "salarySlab"
})
public class Data {

    @JsonProperty("intro")
    private List<Intro> intro = null;
    @JsonProperty("suggestion")
    private List<Object> suggestion = null;
    @JsonProperty("hasPortfolio")
    private Boolean hasPortfolio;
    @JsonProperty("showInvestorProfilePage")
    private Boolean showInvestorProfilePage;
    @JsonProperty("bankVerification")
    private Boolean bankVerification;
    @JsonProperty("eNach")
    private Boolean eNach;
    @JsonProperty("showProfileOnStartup")
    private Boolean showProfileOnStartup;
    @JsonProperty("nomineeRelationship")
    private List<String> nomineeRelationship = null;
    @JsonProperty("isKYCed")
    private Boolean isKYCed;
    @JsonProperty("mandateType")
    private String mandateType;
    @JsonProperty("pendingMandateCard")
    private PendingMandateCard pendingMandateCard;
    @JsonProperty("occupation")
    private List<Occupation> occupation = null;
    @JsonProperty("maritalStatus")
    private List<MaritalStatus> maritalStatus = null;
    @JsonProperty("kycFlowState")
    private Integer kycFlowState;
    @JsonProperty("sampleKycVideos")
    private List<SampleKycVideo> sampleKycVideos = null;
    @JsonProperty("kyc")
    private Kyc kyc;
    @JsonProperty("offlineKycStoreLink")
    private String offlineKycStoreLink;
    @JsonProperty("fullSellAmountPercent")
    private Double fullSellAmountPercent;
    @JsonProperty("ipvVideoDuration")
    private Integer ipvVideoDuration;
    @JsonProperty("ipvVideoSize")
    private Double ipvVideoSize;
    @JsonProperty("showInvestorProfilePageV2")
    private Boolean showInvestorProfilePageV2;
    @JsonProperty("faqUrl")
    private String faqUrl;
    @JsonProperty("homeList")
    private List<HomeList> homeList = null;
    @JsonProperty("salarySlab")
    private List<SalarySlab> salarySlab = null;

    @JsonProperty("intro")
    public List<Intro> getIntro() {
        return intro;
    }

    @JsonProperty("intro")
    public void setIntro(List<Intro> intro) {
        this.intro = intro;
    }

    @JsonProperty("suggestion")
    public List<Object> getSuggestion() {
        return suggestion;
    }

    @JsonProperty("suggestion")
    public void setSuggestion(List<Object> suggestion) {
        this.suggestion = suggestion;
    }

    @JsonProperty("hasPortfolio")
    public Boolean getHasPortfolio() {
        return hasPortfolio;
    }

    @JsonProperty("hasPortfolio")
    public void setHasPortfolio(Boolean hasPortfolio) {
        this.hasPortfolio = hasPortfolio;
    }

    @JsonProperty("showInvestorProfilePage")
    public Boolean getShowInvestorProfilePage() {
        return showInvestorProfilePage;
    }

    @JsonProperty("showInvestorProfilePage")
    public void setShowInvestorProfilePage(Boolean showInvestorProfilePage) {
        this.showInvestorProfilePage = showInvestorProfilePage;
    }

    @JsonProperty("bankVerification")
    public Boolean getBankVerification() {
        return bankVerification;
    }

    @JsonProperty("bankVerification")
    public void setBankVerification(Boolean bankVerification) {
        this.bankVerification = bankVerification;
    }

    @JsonProperty("eNach")
    public Boolean getENach() {
        return eNach;
    }

    @JsonProperty("eNach")
    public void setENach(Boolean eNach) {
        this.eNach = eNach;
    }

    @JsonProperty("showProfileOnStartup")
    public Boolean getShowProfileOnStartup() {
        return showProfileOnStartup;
    }

    @JsonProperty("showProfileOnStartup")
    public void setShowProfileOnStartup(Boolean showProfileOnStartup) {
        this.showProfileOnStartup = showProfileOnStartup;
    }

    @JsonProperty("nomineeRelationship")
    public List<String> getNomineeRelationship() {
        return nomineeRelationship;
    }

    @JsonProperty("nomineeRelationship")
    public void setNomineeRelationship(List<String> nomineeRelationship) {
        this.nomineeRelationship = nomineeRelationship;
    }

    @JsonProperty("isKYCed")
    public Boolean getIsKYCed() {
        return isKYCed;
    }

    @JsonProperty("isKYCed")
    public void setIsKYCed(Boolean isKYCed) {
        this.isKYCed = isKYCed;
    }

    @JsonProperty("mandateType")
    public String getMandateType() {
        return mandateType;
    }

    @JsonProperty("mandateType")
    public void setMandateType(String mandateType) {
        this.mandateType = mandateType;
    }

    @JsonProperty("pendingMandateCard")
    public PendingMandateCard getPendingMandateCard() {
        return pendingMandateCard;
    }

    @JsonProperty("pendingMandateCard")
    public void setPendingMandateCard(PendingMandateCard pendingMandateCard) {
        this.pendingMandateCard = pendingMandateCard;
    }

    @JsonProperty("occupation")
    public List<Occupation> getOccupation() {
        return occupation;
    }

    @JsonProperty("occupation")
    public void setOccupation(List<Occupation> occupation) {
        this.occupation = occupation;
    }

    @JsonProperty("maritalStatus")
    public List<MaritalStatus> getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("maritalStatus")
    public void setMaritalStatus(List<MaritalStatus> maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @JsonProperty("kycFlowState")
    public Integer getKycFlowState() {
        return kycFlowState;
    }

    @JsonProperty("kycFlowState")
    public void setKycFlowState(Integer kycFlowState) {
        this.kycFlowState = kycFlowState;
    }

    @JsonProperty("sampleKycVideos")
    public List<SampleKycVideo> getSampleKycVideos() {
        return sampleKycVideos;
    }

    @JsonProperty("sampleKycVideos")
    public void setSampleKycVideos(List<SampleKycVideo> sampleKycVideos) {
        this.sampleKycVideos = sampleKycVideos;
    }

    @JsonProperty("kyc")
    public Kyc getKyc() {
        return kyc;
    }

    @JsonProperty("kyc")
    public void setKyc(Kyc kyc) {
        this.kyc = kyc;
    }

    @JsonProperty("offlineKycStoreLink")
    public String getOfflineKycStoreLink() {
        return offlineKycStoreLink;
    }

    @JsonProperty("offlineKycStoreLink")
    public void setOfflineKycStoreLink(String offlineKycStoreLink) {
        this.offlineKycStoreLink = offlineKycStoreLink;
    }

    @JsonProperty("fullSellAmountPercent")
    public Double getFullSellAmountPercent() {
        return fullSellAmountPercent;
    }

    @JsonProperty("fullSellAmountPercent")
    public void setFullSellAmountPercent(Double fullSellAmountPercent) {
        this.fullSellAmountPercent = fullSellAmountPercent;
    }

    @JsonProperty("ipvVideoDuration")
    public Integer getIpvVideoDuration() {
        return ipvVideoDuration;
    }

    @JsonProperty("ipvVideoDuration")
    public void setIpvVideoDuration(Integer ipvVideoDuration) {
        this.ipvVideoDuration = ipvVideoDuration;
    }

    @JsonProperty("ipvVideoSize")
    public Double getIpvVideoSize() {
        return ipvVideoSize;
    }

    @JsonProperty("ipvVideoSize")
    public void setIpvVideoSize(Double ipvVideoSize) {
        this.ipvVideoSize = ipvVideoSize;
    }

    @JsonProperty("showInvestorProfilePageV2")
    public Boolean getShowInvestorProfilePageV2() {
        return showInvestorProfilePageV2;
    }

    @JsonProperty("showInvestorProfilePageV2")
    public void setShowInvestorProfilePageV2(Boolean showInvestorProfilePageV2) {
        this.showInvestorProfilePageV2 = showInvestorProfilePageV2;
    }

    @JsonProperty("faqUrl")
    public String getFaqUrl() {
        return faqUrl;
    }

    @JsonProperty("faqUrl")
    public void setFaqUrl(String faqUrl) {
        this.faqUrl = faqUrl;
    }

    @JsonProperty("homeList")
    public List<HomeList> getHomeList() {
        return homeList;
    }

    @JsonProperty("homeList")
    public void setHomeList(List<HomeList> homeList) {
        this.homeList = homeList;
    }

    @JsonProperty("salarySlab")
    public List<SalarySlab> getSalarySlab() {
        return salarySlab;
    }

    @JsonProperty("salarySlab")
    public void setSalarySlab(List<SalarySlab> salarySlab) {
        this.salarySlab = salarySlab;
    }

}
