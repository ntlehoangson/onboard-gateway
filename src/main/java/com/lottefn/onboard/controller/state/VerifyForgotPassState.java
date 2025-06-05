package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class VerifyForgotPassState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyForgotPassState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, Events event, Map<String, Object> data) throws Exception {
        if (event == Events.OTP_SENT) {
            instance.setOtpSent(true);
            instance.setCurrentState(States.VERIFY_RESET_PASS);
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_FORGOT_PASS");
        }

        repository.save(instance);
    }


}
