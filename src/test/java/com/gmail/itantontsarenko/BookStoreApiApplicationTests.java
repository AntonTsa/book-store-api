package com.gmail.itantontsarenko;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class BookStoreApiApplicationTests {

	@Test
	void contextLoads() {

	}

    @Test
    void verifiesModularStructure() {
        ApplicationModules modules = ApplicationModules.of(BookStoreApiApplication.class);
        modules.verify();
    }

}
