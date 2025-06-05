package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class CompleteState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public CompleteState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, Events event, Map<String, Object> data) throws Exception {
        throw new IllegalStateException("Workflow already completed");
    }


}
