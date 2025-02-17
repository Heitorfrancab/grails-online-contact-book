package com.heitor.ocb

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class SecurityInterceptorSpec extends Specification implements InterceptorUnitTest<SecurityInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test security interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"security")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
