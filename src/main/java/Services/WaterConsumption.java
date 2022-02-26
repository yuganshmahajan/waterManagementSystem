package Services;

import Entities.Apartment;

/**
 * WaterConsumtion Implementations are different for Members and Guest
 * So In order to decouple Application and WaterConsumption Strategy, we have used
 * an implementation layer here.
 */

public interface WaterConsumption {
    int getWaterConsumption(int noOfPeople);
    int getWaterBill(Apartment apt);
}
