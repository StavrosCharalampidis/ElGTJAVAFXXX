package app.PartyPackage;


public class PartyEvent {
    private String partyCode;
    private String partyDate;
    private String partyDetails;
    private Double partyPrice;

    public PartyEvent(String partyCode, String partyDate, String partyDetails, Double partyPrice) {
        this.partyCode = partyCode;
        this.partyDate = partyDate;
        this.partyDetails = partyDetails;
        this.partyPrice = partyPrice;
    }
    
    public PartyEvent() {};
    
    public String getPartyCode() {
        return this.partyCode;
    }
    
    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }
    
    public String getpartyDate() {
        return this.partyDate;
    }
    
    public void setpartyDate(String partyDate) {
        this.partyDate = partyDate;
    }
    
    public String getpartyDetails() {
        return this.partyDetails;
    }
    
    public void setpartyDetails(String partyDetails) {
        this.partyDetails = partyDetails;
    }
    
    public Double getpartyPrice() {
        return this.partyPrice;
    }
    
    public void setpartyPrice(Double partyPrice) {
        this.partyPrice = partyPrice;
    }

}
