package com.lottefn.onboard.controller;

import java.util.Map;

public interface WorkflowState {
        void handleEvent(WorkflowInstance instance, Events event, Map<String, Object> data) throws Exception;

}
