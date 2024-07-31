package com.sample.domain.member;

import java.util.Optional;

public interface MemberReader {
    Optional<Member> readMember(Long id);
    boolean isMember(Long id);
}
