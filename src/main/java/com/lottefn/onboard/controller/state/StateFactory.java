package com.lottefn.onboard.controller.state;

import com.lottefn.onboard.controller.WorkflowState;
import com.lottefn.onboard.controller.States;
import com.lottefn.onboard.controller.WorkflowInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateFactory {

    @Autowired
    private WorkflowInstanceRepository repository;

    public WorkflowState getState(States state) {
        return switch (state) {
            case VERIFY_START -> new VerifyStartState(repository);
            case VERIFY_CHECK_USER -> new VerifyCheckUserState(repository);
            case VERIFY_FORGOT_PASS -> new VerifyForgotPassState(repository);
            case VERIFY_ENTER_PASS -> new VerifyEnterPassState(repository);
            case VERIFY_RESET_PASS -> new VerifyResetPassState(repository);
            case E_KYC -> new EKYCState(repository);
            case ADD_INFO -> new AddInfoState(repository);
            case UNDERWRITING -> new UnderwritingState(repository);
            case COMPLETE -> new CompleteState(repository);
            default -> throw new IllegalArgumentException("State không hợp lệ");
        };
    }
}
