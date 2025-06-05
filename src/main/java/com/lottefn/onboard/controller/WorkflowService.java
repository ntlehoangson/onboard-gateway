package com.lottefn.onboard.controller;

import com.lottefn.onboard.controller.state.StateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WorkflowService {

    @Autowired
    private WorkflowInstanceRepository repository;

    @Autowired
    private StateFactory stateFactory;

    public WorkflowInstance createWorkflow(String orderId, String phone, String userId) {
        WorkflowInstance instance = new WorkflowInstance();
        instance.setOrderId(orderId);
        instance.setPhone(phone);
        instance.setUserId(userId);
        instance.setCurrentState(States.VERIFY_START);
        repository.save(instance);
        return instance;
    }

    public WorkflowInstance handleEvent(Long instanceId, Events event, Map<String, Object> data) throws Exception {
        WorkflowInstance instance = repository.findById(instanceId)
                .orElseThrow(() -> new IllegalArgumentException("WorkflowInstance không tồn tại"));

        WorkflowState workflowState = stateFactory.getState(instance.getCurrentState());
        workflowState.handleEvent(instance, event, data);

        return repository.save(instance);
    }

    public WorkflowInstance getWorkflowInstance(Long instanceId) {
        return repository.findById(instanceId)
                .orElseThrow(() -> new IllegalArgumentException("WorkflowInstance không tồn tại"));
    }
}
