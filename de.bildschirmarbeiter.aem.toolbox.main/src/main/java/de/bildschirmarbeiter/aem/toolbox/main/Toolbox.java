package de.bildschirmarbeiter.aem.toolbox.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.bildschirmarbeiter.application.osgi.OsgiApplication;

public class Toolbox extends OsgiApplication {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    protected Map<String, String> configuration() {
        final List<String> packages = new ArrayList<>();
        try (final InputStream inputStream = getClass().getResourceAsStream("/configuration/org.osgi.framework.system.packages.extra")) {
            readLines(inputStream, packages);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final Map<String, String> configuration = new HashMap<>();
        configuration.put("org.osgi.framework.system.packages.extra", String.join(",", packages));
        return configuration;
    }

    @Override
    protected List<String> bundles() {
        final List<String> bundles = new ArrayList<>();
        try (final InputStream inputStream = getClass().getResourceAsStream("/bundles")) {
            readLines(inputStream, bundles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bundles;
    }

}
