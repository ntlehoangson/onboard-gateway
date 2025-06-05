package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class VerifyResetPassState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyResetPassState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, Events event, Map<String, Object> data) throws Exception {
        if (event == Events.PASSWORD_RESET) {
            instance.setPasswordSetFirstTime(true);
            instance.setCurrentState(States.E_KYC);
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_RESET_PASS");
        }

        repository.save(instance);
    }


}
