package com.engine;

import java.io.IOException;

public interface ApiTestCase {

    public void setup() throws IOException;
    public void setBaseUri() throws IOException;
    public void resetUri() throws IOException;
    public void tearDown();

}
