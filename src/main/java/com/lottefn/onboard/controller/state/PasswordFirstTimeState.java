package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.WorkflowInstance;
import com.lottefn.onboard.controller.WorkflowInstanceRepository;
import com.lottefn.onboard.controller.WorkflowState;

import java.util.Map;

public class PasswordFirstTimeState implements WorkflowState {
    private  WorkflowInstanceRepository repository;

    public PasswordFirstTimeState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, String event, Map<String, Object> data) throws Exception {
        String newPass = (String) data.get("newPassword");
        // ... validate + hash password
        instance.setPasswordSetFirstTime(true);
    }
}
