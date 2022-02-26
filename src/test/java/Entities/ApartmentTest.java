package Entities;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApartmentTest {

    private Apartment apartmentUnderTest;

    @BeforeEach
    void setUp() {
        apartmentUnderTest = Apartment.getInstance(ApartmentType.TWO_BHK, 0, 0);
    }

    @Test
    void testAddGuests() {
        // Setup

        // Run the test
        apartmentUnderTest.addGuests(6);
        apartmentUnderTest.addGuests(4);

        // Verify the results
        Assert.assertEquals(apartmentUnderTest.getNoOfGuests(), 10);
    }

    @Test
    void testGenerateBill_2BHK() {
        // Setup
        apartmentUnderTest.setAptType(ApartmentType.TWO_BHK);
        apartmentUnderTest.addGuests(2);
        apartmentUnderTest.addGuests(3);
        apartmentUnderTest.setCorporationRatio(3);
        apartmentUnderTest.setBoreWellRatio(7);
        // Run the test
        apartmentUnderTest.generateBill();

        // Verify the results
        Assert.assertEquals(apartmentUnderTest.getM_guestBill(), 4000);
        Assert.assertEquals(apartmentUnderTest.getM_memberBill(), 1215);
        Assert.assertEquals(apartmentUnderTest.getM_totalWaterConsumption(), 2400);
        Assert.assertEquals(apartmentUnderTest.getM_bill(), 5215);
    }

    @Test
    void testGenerateBill_3BHK() {
        // Setup
        apartmentUnderTest.setAptType(ApartmentType.THREE_BHK);
        apartmentUnderTest.addGuests(4);
        apartmentUnderTest.addGuests(1);
        apartmentUnderTest.setCorporationRatio(2);
        apartmentUnderTest.setBoreWellRatio(1);
        // Run the test
        apartmentUnderTest.generateBill();

        // Verify the results
        Assert.assertEquals(apartmentUnderTest.getM_guestBill(), 4000);
        Assert.assertEquals(apartmentUnderTest.getM_memberBill(), 1750);
        Assert.assertEquals(apartmentUnderTest.getM_totalWaterConsumption(), 3000);
        Assert.assertEquals(apartmentUnderTest.getM_bill(), 5750);
    }
}
