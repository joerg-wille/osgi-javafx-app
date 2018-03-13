package de.bildschirmarbeiter.application.message.spi;

import javax.annotation.Nonnull;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface MessageService {

    void send(@Nonnull final Object message);

    void register(@Nonnull final Object listener);

    void unregister(@Nonnull final Object listener);

}
