package com.lottefn.onboard.controller;

import java.util.Map;

public interface WorkflowState {
        void handleEvent(WorkflowInstance instance, String event, Map<String, Object> req) throws Exception;

}
