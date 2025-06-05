package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class VerifyResetPassState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyResetPassState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, String event, Map<String, Object> data) throws Exception {
        if (event == States.VERIFY_RESET_PASS.name()) {
            if(customer ton tai, vaf update passxong)

            instance.setPasswordSetFirstTime(true);
            instance.setCurrentState(States.E_KYC.name());
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_RESET_PASS");
        }

        repository.save(instance);
    }


}
