package Entities;

import Services.WaterConsumptionFactory;

/**
 * Singleton Design pattern used as Apartment should be initialised only once
 * throughout our application.
 * */

public class Apartment {
    private ApartmentType aptType;
    private int noOfGuests;
    private int corporationRatio;
    private int boreWellRatio;
    private int m_memberWaterConsumption;
    private int m_guestWaterConsumption;
    private int m_totalWaterConsumption;
    private int m_guestBill;
    private int m_memberBill;
    private int m_bill;
    private WaterConsumptionFactory waterConsumptionFactory;
    private static Apartment m_apt;

    public static Apartment getInstance(ApartmentType aptType, int corpRatio, int boreRatio) {
        if(m_apt != null) {
            System.out.println("Apartment Already Allotted");
            return m_apt;
        }
        return new Apartment(aptType, corpRatio, boreRatio);
    }

    private Apartment(ApartmentType aptType, int corpRatio, int boreRatio) {
        this.aptType = aptType;
        this.corporationRatio = corpRatio;
        this.boreWellRatio = boreRatio;
        this.noOfGuests = 0;
        waterConsumptionFactory = new WaterConsumptionFactory();
    }

    public void addGuests(int noOfGuests) {
        this.noOfGuests += noOfGuests;
    }
    private int getNumberOfMembers() {
        if(aptType == null) {
            return -1;
        }
        if(aptType == ApartmentType.TWO_BHK) {
            return 3;
        }
        if(aptType == ApartmentType.THREE_BHK) {
            return 5;
        }
        System.out.println("Incorrect Apt Type");
        return -1;
    }

    private void calculateTotalWaterConsumption() {
        m_memberWaterConsumption = waterConsumptionFactory.getWaterConsumptionType(Constants.GUEST).
                getWaterConsumption(getNumberOfMembers());
        m_guestWaterConsumption = waterConsumptionFactory.getWaterConsumptionType(Constants.MEMBER).
                getWaterConsumption(getNoOfGuests());
        m_totalWaterConsumption = m_memberWaterConsumption + m_guestWaterConsumption;
    }

    private void calculateBill() {
        m_guestBill = waterConsumptionFactory.getWaterConsumptionType(Constants.GUEST).
                getWaterBill(this);
        m_memberBill = waterConsumptionFactory.getWaterConsumptionType(Constants.MEMBER).
                getWaterBill(this);
        m_bill = m_guestBill + m_memberBill;
    }

    public int getM_guestBill() {
        return m_guestBill;
    }

    public void setM_guestBill(int m_guestBill) {
        this.m_guestBill = m_guestBill;
    }

    public int getM_memberBill() {
        return m_memberBill;
    }

    public void setM_memberBill(int m_memberBill) {
        this.m_memberBill = m_memberBill;
    }

    public int getM_bill() {
        return m_bill;
    }

    public void setM_bill(int m_bill) {
        this.m_bill = m_bill;
    }

    public void generateBill(){
        calculateTotalWaterConsumption();
        calculateBill();
        int totalBill = getM_bill();
        //System.out.println(getM_guestBill() + "  " + getM_memberBill());
        System.out.print(getM_totalWaterConsumption() + " " + getM_bill());
    }

    public int getM_memberWaterConsumption() {
        return m_memberWaterConsumption;
    }

    public void setM_memberWaterConsumption(int m_memberWaterConsumption) {
        this.m_memberWaterConsumption = m_memberWaterConsumption;
    }

    public int getM_guestWaterConsumption() {
        return m_guestWaterConsumption;
    }

    public void setM_guestWaterConsumption(int m_guestWaterConsumption) {
        this.m_guestWaterConsumption = m_guestWaterConsumption;
    }

    public int getM_totalWaterConsumption() {
        return m_totalWaterConsumption;
    }

    public void setM_totalWaterConsumption(int m_totalWaterConsumption) {
        this.m_totalWaterConsumption = m_totalWaterConsumption;
    }

    public ApartmentType getAptType() {
        return aptType;
    }

    public void setAptType(ApartmentType aptType) {
        this.aptType = aptType;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public int getCorporationRatio() {
        return corporationRatio;
    }

    public void setCorporationRatio(int corporationRatio) {
        this.corporationRatio = corporationRatio;
    }

    public int getBoreWellRatio() {
        return boreWellRatio;
    }

    public void setBoreWellRatio(int boreWellRatio) {
        this.boreWellRatio = boreWellRatio;
    }
}
