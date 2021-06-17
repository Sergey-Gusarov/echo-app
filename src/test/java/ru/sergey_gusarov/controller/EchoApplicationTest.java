package ru.sergey_gusarov.controller;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sergey_gusarov.EchoApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j
@SpringBootTest(classes = EchoApplication.class)
class EchoApplicationTest {
    @Test
    void main() {
        assertEquals(true, true);
    }
}
