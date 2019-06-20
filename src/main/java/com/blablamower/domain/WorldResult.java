package com.blablamower.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class WorldResult {

    World initialWorld;
    Position[] positions;

}
