package com.engine;

import java.io.IOException;

public interface UiTestCase {

    public void setup() throws IOException;
    public void tearDown();

}
