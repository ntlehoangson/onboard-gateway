package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class VerifyStartState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyStartState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, Events event, Map<String, Object> data) throws Exception {
        if (event == Events.START_VERIFY) {
            instance.setPhone((String) data.get("phone"));
            instance.setCurrentState(States.VERIFY_CHECK_USER);
            repository.save(instance);
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_START");
        }
    }


}