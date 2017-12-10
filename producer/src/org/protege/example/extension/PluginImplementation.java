package org.protege.example.extension;

import org.apache.log4j.Logger;
import org.protege.editor.owl.model.OWLModelManager;
import org.protege.example.extension.point.api.MyPluginInstance;

public class PluginImplementation implements MyPluginInstance {

    private static Logger logger = Logger.getLogger(PluginImplementation.class);
    
    private OWLModelManager manager;

    @Override
    public void doSomething() {
        logger.info("Current Ontology = " + manager.getActiveOntology().getOntologyID().toString());
    }

    @Override
    public void setup(final OWLModelManager manager, final String type) {
        this.manager = manager;
        logger.info("My type is " + type);
    }

    @Override
    public void initialise() {
    }

    @Override
    public void dispose() {
    }
}
