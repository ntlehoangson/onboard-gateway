package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class VerifyCheckUserState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyCheckUserState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, Events event, Map<String, Object> data) throws Exception {
        if (event == Events.USER_CHECKED_EXISTS) {
            instance.setUserExists(true);
            instance.setCurrentState(States.VERIFY_ENTER_PASS);
        } else if (event == Events.USER_NOT_EXISTS) {
            instance.setUserExists(false);
            instance.setCurrentState(States.VERIFY_FORGOT_PASS);
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_CHECK_USER");
        }

        repository.save(instance);
    }


}