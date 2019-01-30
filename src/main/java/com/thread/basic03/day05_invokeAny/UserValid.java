package com.thread.basic03.day05_invokeAny;

import java.util.Random;

public class UserValid {
    private String validId;

    public UserValid(String validId) {
        this.validId = validId;
    }

    public boolean valid() {
        boolean result = false;
        Random random = new Random();

        try {
            System.out.printf("%s 验证中。。。\n", validId);
            result = random.nextBoolean();
            if (result) {
                System.out.printf("%s 验证完成。。。\n", validId);
            } else {
                System.out.printf("%s 验证失败。。。\n", validId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getValidId() {
        return validId;
    }
}
