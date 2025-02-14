package com.heitor.ocb

import com.heitor.ocb.GlobalConfig

class Member {
    Integer id
    String firstName
    String lastName
    String email
    String password
    String memberType = GlobalConfig.USER_TYPE.REGULAR_MEMBER
    String identityHash
    String identityHashLastUpdate
    Boolean isActive = true

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email email: true, nullable: false, unique: true, blank: false
        password blank: false
        lastName nullable: true
        identityHash nullable: true
        identityHashLastUpdate nullable: true
    }

    static mapping = {
        id generator: 'identity' // Define ID automático
        table 'member' // Evita possíveis conflitos com palavras reservadas do banco
    }

    def beforeInsert() {
        this.password = this.password.encodeAsMD5()
    }

    def beforeUpdate() {
        this.password = this.password.encodeAsMD5()
    }
}
