package team.hau.sam.factory;

import team.hau.sam.service.*;
import team.hau.sam.service.impl.*;

public class ServiceFactory {
    public static LoginService getLoginServiceInstance() {
        return new LoginServiceImpl();
    }

    public static SignupService getSignupServiceInstance() {
        return new SignupServiceImpl();
    }
    public static PeasantHouseholdService getPeasantHouseholdServiceInstance() {
        return new PeasantHouseholdServiceImpl();
    }


}
