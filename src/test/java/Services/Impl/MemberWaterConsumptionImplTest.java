package Services.Impl;

import Entities.Apartment;
import Entities.ApartmentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberWaterConsumptionImplTest {

    private MemberWaterConsumptionImpl memberWaterConsumptionImplUnderTest;

    @BeforeEach
    void setUp() {
        memberWaterConsumptionImplUnderTest = new MemberWaterConsumptionImpl();
    }

    @Test
    void testGetWaterConsumption() {
        assertEquals(0, memberWaterConsumptionImplUnderTest.getWaterConsumption(0));
    }

    @Test
    void testGetWaterBill() {
        // Setup
        final Apartment apt = Apartment.getInstance(ApartmentType.TWO_BHK, 0, 0);

        // Run the test
        final int result = memberWaterConsumptionImplUnderTest.getWaterBill(apt);

        // Verify the results
        assertEquals(0, result);
    }
}
