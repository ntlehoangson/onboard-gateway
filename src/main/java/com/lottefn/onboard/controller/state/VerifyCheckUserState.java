package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

import static com.lottefn.onboard.controller.States.E_KYC;
import static com.lottefn.onboard.controller.States.VERIFY_CHECK_USER;

public class VerifyCheckUserState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyCheckUserState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, String event, Map<String, Object> data) throws Exception {
        if(event == VERIFY_CHECK_USER.name()){

            if(data.get("password") == userpassword trong db){
                instance.setCurrentState(E_KYC.name());
            }
            if(data.get("quenmk") == true){
                sendOTP();
                instance.setCurrentState(States.VERIFY_FORGOT_PASS.name());
            }
            repository.save(instance);

//        if (event == Events.USER_CHECKED_EXISTS.name()) {
//            instance.setFirstAuthen(true);
//            instance.setCurrentState(States.VERIFY_ENTER_PASS.name());
//        } else if (event == Events.USER_NOT_EXISTS.name()) {
//            instance.setFirstAuthen(false);
//            instance.setCurrentState(States.VERIFY_FORGOT_PASS.name());
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_CHECK_USER");
        }

    }


}