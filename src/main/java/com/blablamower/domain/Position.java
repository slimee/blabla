package com.blablamower.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static java.lang.String.format;

@EqualsAndHashCode
@Builder
@Getter
public class Position {
    private int x;
    private int y;
    private Orientation orientation;

    @Override
    public String toString() {
        return format("%d %d %s", getX(), getY(), getOrientation());
    }
}
