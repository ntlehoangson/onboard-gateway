package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class UnderwritingState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public UnderwritingState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, Events event, Map<String, Object> data) throws Exception {
        if (event == Events.UW_DONE) {
            instance.setCurrentState(States.COMPLETE);
        } else {
            throw new IllegalStateException("Invalid event for UNDERWRITING");
        }

        repository.save(instance);
    }


}
