package de.bildschirmarbeiter.application.message.base;

import java.util.UUID;

import javax.annotation.Nonnull;

import de.bildschirmarbeiter.application.message.api.Message;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public abstract class AbstractMessage implements Message {

    private final long _timestamp = System.nanoTime();

    private final UUID _uuid = UUID.randomUUID();

    private final Object _source;

    public AbstractMessage(@Nonnull final Object source) {
        _source = source;
    }

    @Override
    @Nonnull
    public Long timestamp() {
        return _timestamp;
    }

    @Override
    @Nonnull
    public UUID uuid() {
        return _uuid;
    }

    @Override
    @Nonnull
    public Object source() {
        return _source;
    }

}
