package com.acme.sporteaseplatform.iam.infrastructure.hashing.bcrypt;

import com.acme.sporteaseplatform.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
    
}
