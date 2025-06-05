package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class VerifyStartState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public VerifyStartState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, String event, Map<String, Object> data) throws Exception {
        if (event == Events.START_VERIFY.name()) {
           //neu co id va phone trong db thi chuyen sang step nay

            if(data.getPassword == landau ){
                instance.setFirstAuthen(true);
                instance.setCurrentState(States.VERIFY_RESET_PASS.name());
            }else{
                instance.setCurrentState(States.VERIFY_CHECK_USER.name());
            }
            repository.save(instance);
        } else {
            throw new IllegalStateException("Invalid event for VERIFY_START");
        }
    }


}