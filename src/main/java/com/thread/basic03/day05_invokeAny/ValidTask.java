package com.thread.basic03.day05_invokeAny;

import java.util.concurrent.Callable;

public class ValidTask implements Callable<String> {
    private UserValid userValid;

    public ValidTask(UserValid userValid) {
        this.userValid = userValid;
    }

    @Override
    public String call() throws Exception {
        if (!userValid.valid()) {
            throw new Exception("验证失败");
        }

        return userValid.getValidId();
    }
}
