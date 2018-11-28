package com.mjolnir.springboot;

/**
 * @author huangzhibo
 * @date 30/01/2018
 */
public interface FailureAnalyzer {

    FailureAnalysis analyze(Throwable failure);

}
