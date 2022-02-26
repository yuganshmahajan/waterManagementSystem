package Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WaterConsumptionFactoryTest {

    private WaterConsumptionFactory waterConsumptionFactoryUnderTest;

    @BeforeEach
    void setUp() {
        waterConsumptionFactoryUnderTest = new WaterConsumptionFactory();
    }

    @Test
    void testGetWaterConsumptionType() {
        // Setup

        // Run the test
        final WaterConsumption result = waterConsumptionFactoryUnderTest.getWaterConsumptionType("memberType");

        // Verify the results
    }
}
