package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class AddInfoState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public AddInfoState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, Events event, Map<String, Object> data) throws Exception {
        if (event == Events.ADD_INFO_DONE) {
            instance.setTenCoQuan((String) data.get("tenCoQuan"));
            instance.setSoLanAccept((Integer) data.get("soLanAccept"));
            instance.setCurrentState(States.UNDERWRITING);
        } else {
            throw new IllegalStateException("Invalid event for ADD_INFO");
        }

        repository.save(instance);
    }


}