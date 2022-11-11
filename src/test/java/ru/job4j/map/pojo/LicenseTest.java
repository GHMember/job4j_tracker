package ru.job4j.map.pojo;
import org.junit.jupiter.api.Test;
import ru.job4j.pojo.License;

import static org.assertj.core.api.Assertions.assertThat;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first).isEqualTo(second);
    }
}