package com.ksomon.progressive.goals.action;

import java.io.IOException;

public interface Action {

    /**
     * Execute a single action
     * @throws IOException
     */
    void execute() throws IOException;

}
