package com.saransh.msscbeerservice.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Created by CryptoSingh1337 on 7/26/2021
 */
@Component
public class DateMapper {

    public OffsetDateTime asOffsetDateTime(Timestamp ts) {
        if (ts != null)
            return OffsetDateTime.of(ts.toLocalDateTime(), ZoneOffset.UTC);
        return null;
    }

    public Timestamp asTimestamp(OffsetDateTime of) {
        if (of != null)
            return Timestamp.valueOf(of.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        return null;
    }
}
