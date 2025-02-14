package com.heitor.ocb

class MemberInterceptor {

    AuthenticationService AuthenticationService

    boolean before() {
        if (AuthenticationService.isAdministratorMember()){
            return true
        }
        flash.message = AppUtil.infoMessage("You are not Authorized for this action.", false)
        redirect(controller: "dashboard", action: "index")
        return false
    }
}
