package Services.Impl;

import Entities.Apartment;
import Entities.Constants;
import Services.WaterConsumption;

public class GuestWaterConsumptionImpl implements WaterConsumption {
    @Override
    public int getWaterConsumption(int guests) {
        return guests * Constants.GUEST_WATER_ALLOTMENT * Constants.MONTH_DAYS;
    }

    @Override
    public int getWaterBill(Apartment apt) {
        int waterConsumed = apt.getM_guestWaterConsumption();
        int totalBill = 0;
        if(waterConsumed > 3000) {
            int billedWater = (waterConsumed - 3000);
            totalBill += billedWater * 8;
            waterConsumed -= billedWater;
        }
        if(waterConsumed > 1500) {
            int billedWater = (waterConsumed - 1500);
            totalBill += billedWater * 5;
            waterConsumed -= billedWater;
        }
        if(waterConsumed > 500) {
            int billedWater = (waterConsumed - 500);
            totalBill += billedWater * 3;
            waterConsumed -= billedWater;
        }
        if(waterConsumed > 0) {
            totalBill += waterConsumed * 2;
        }
        return totalBill;
    }
}
