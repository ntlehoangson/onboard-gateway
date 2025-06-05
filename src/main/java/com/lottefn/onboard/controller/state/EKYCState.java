package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.*;

import java.util.Map;

public class EKYCState implements WorkflowState {

    private final WorkflowInstanceRepository repository;

    public EKYCState(WorkflowInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handleEvent(WorkflowInstance instance, String event, Map<String, Object> data) throws Exception {
        if (event == Events.E_KYC_DONE.name()) {
            instance.setFullName((String) data.get("fullName"));
            instance.setDob((String) data.get("dob"));
            instance.setDiaChi((String) data.get("diaChi"));
            instance.setGioiTinh((String) data.get("gioiTinh"));
            instance.setTrangThai((String) data.get("trangThai"));
            instance.setCongViec((String) data.get("congViec"));
            instance.setCurrentState(States.ADD_INFO.name());
        } else {
            throw new IllegalStateException("Invalid event for E_KYC");
        }

        repository.save(instance);
    }


}
