package com.heitor.ocb

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class MemberInterceptorSpec extends Specification implements InterceptorUnitTest<MemberInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test memberinterceptor interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"memberinterceptor")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
