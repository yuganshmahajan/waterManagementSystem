package Services.Impl;

import Entities.Apartment;
import Entities.ApartmentType;
import Entities.Constants;
import Services.WaterConsumption;

public class MemberWaterConsumptionImpl implements WaterConsumption {
    @Override
    public int getWaterConsumption(int members) {
        return members * Constants.MEMBER_WATER_ALLOTMENT * Constants.MONTH_DAYS;
    }

    @Override
    public int getWaterBill(Apartment apt) {
        double totalRatio = apt.getBoreWellRatio() + apt.getCorporationRatio();
        double corpBill = (apt.getCorporationRatio() / totalRatio) * apt.getM_memberWaterConsumption()
                * Constants.CORPORATION_WATER_COST;
        double boreBill = ((apt.getBoreWellRatio() / totalRatio)  * apt.getM_memberWaterConsumption() *
                Constants.BOREWELL_WATER_COST);
        return (int)Math.ceil(corpBill + boreBill);
    }
}
