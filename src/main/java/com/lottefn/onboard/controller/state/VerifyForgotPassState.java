package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class VerifyForgotPassState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyForgotPassState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, String event, Map<String, Object> data) throws Exception {
        if (event == States.VERIFY_FORGOT_PASS.name()) {
            if(nhap otp = "123"){
                instance.setCurrentState(States.VERIFY_RESET_PASS.name());
            }


//            instance.setOtpSent(true);
//            instance.setCurrentState(States.VERIFY_RESET_PASS.name());
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_FORGOT_PASS");
        }

        repository.save(instance);
    }


}
