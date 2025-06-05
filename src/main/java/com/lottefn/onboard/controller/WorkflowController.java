package com.lottefn.onboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    // Tạo workflow mới
    @PostMapping("/start")
    public ResponseEntity<WorkflowInstance> startWorkflow(@RequestBody Map<String, String> input) {
        String orderId = input.get("orderId");
//        String phone = input.get("phone");
//        String userId = input.get("userId");
        WorkflowInstance instance = workflowService.createWorkflow(orderId);
        return ResponseEntity.ok(instance);
    }

    // Gửi event chuyển trạng thái
    @PostMapping("/{id}/event")
    public ResponseEntity<WorkflowInstance> sendEvent(
            @PathVariable("id") Long id,
            @RequestParam(value = "event", required = false) String event,
            @RequestBody(required = false) Map<String, Object> data) throws Exception {
        if (data == null) data = new HashMap<>();
        if (event == "" || event == null) {
            WorkflowInstance instance = workflowService.getWorkflowInstance(id);
            event = instance.getCurrentState();
        }
        WorkflowInstance instance = workflowService.handleEvent(id, event, data);
        return ResponseEntity.ok(instance);
    }

    // Lấy trạng thái workflow hiện tại
    @GetMapping("/{id}")
    public ResponseEntity<WorkflowInstance> getWorkflow(@PathVariable("id") Long id) {
        WorkflowInstance instance = workflowService.getWorkflowInstance(id);
        return ResponseEntity.ok(instance);
    }
}
