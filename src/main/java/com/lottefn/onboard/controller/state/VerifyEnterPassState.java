package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class VerifyEnterPassState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyEnterPassState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, String event, Map<String, Object> data) throws Exception {
        if (event == Events.PASSWORD_ENTERED.name()) {
            instance.setPasswordSetFirstTime(false);
            instance.setCurrentState(States.E_KYC.name());
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_ENTER_PASS");
        }

        repository.save(instance);
    }


}