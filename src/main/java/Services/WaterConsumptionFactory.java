package Services;

import Entities.Constants;
import Services.Impl.GuestWaterConsumptionImpl;
import Services.Impl.MemberWaterConsumptionImpl;

/** Factory Design pattern is Used to Separate GuestWaterConsumption implementation
 *  and MemberWaterConsumption Implemetation. In this way, Our application has
 *  achieved loose coupling.
 *  Also if a new type of Water Consumption strategy needs to be added,
 *  it can be achieved without affecting existing code. So it made our applictaion
 *  extensible.
 * */

public class WaterConsumptionFactory {
    public WaterConsumption getWaterConsumptionType(String memberType) {
        if(memberType == null){
            return null;
        }
        if(memberType == Constants.GUEST) {
            return new GuestWaterConsumptionImpl();
        }
        if(memberType == Constants.MEMBER) {
            return new MemberWaterConsumptionImpl();
        }
        return null;
    }
}
