package de.bildschirmarbeiter.application.message.api;

import java.util.UUID;

import javax.annotation.Nonnull;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Message {

    @Nonnull
    Long timestamp();

    @Nonnull
    UUID uuid();

    @Nonnull
    Object source();

}
