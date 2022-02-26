package Services.Impl;

import Entities.Apartment;
import Entities.ApartmentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuestWaterConsumptionImplTest {

    private GuestWaterConsumptionImpl guestWaterConsumptionImplUnderTest;

    @BeforeEach
    void setUp() {
        guestWaterConsumptionImplUnderTest = new GuestWaterConsumptionImpl();
    }

    @Test
    void testGetWaterConsumption() {
        assertEquals(0, guestWaterConsumptionImplUnderTest.getWaterConsumption(0));
    }

    @Test
    void testGetWaterBill() {
        // Setup
        final Apartment apt = Apartment.getInstance(ApartmentType.TWO_BHK, 0, 0);

        // Run the test
        final int result = guestWaterConsumptionImplUnderTest.getWaterBill(apt);

        // Verify the results
        assertEquals(0, result);
    }
}
