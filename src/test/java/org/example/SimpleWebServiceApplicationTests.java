/*
 * SimpleWebServiceApplicationTests.java
 *
 * Created on 2022-08-01
 *
 * Copyright (C) 2022 Volkswagen AG, All rights reserved.
 */

package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleWebServiceApplicationTests {

    @Test
    void simpleTest() {
        final int x = 3;
        final int y = 3;
        final int z = 9;

        assertThat(x * y).isEqualTo(z);
    }

}
