package com.fms.jnosql;

import jakarta.nosql.document.DocumentCollectionManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class DocumentCollectionManagerProducer {

    @Inject
    @ConfigProperty(name = "document")
    private DocumentCollectionManager entityManager;

    @Produces
    public DocumentCollectionManager getManager() {
        return entityManager;
    }

}