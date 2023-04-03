package com.eduwithu.EduWithU;

import Service.FirebaseService1;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

public class FirebaseTest {
    @Resource
    FirebaseService1 firebaseService;

    @Test
    public void test() throws Exception {
        firebaseService.selectUser();
    }
}
