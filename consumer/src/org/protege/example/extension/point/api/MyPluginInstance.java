package org.protege.example.extension.point.api;

import org.protege.editor.core.plugin.ProtegePluginInstance;
import org.protege.editor.owl.model.OWLModelManager;

public interface MyPluginInstance extends ProtegePluginInstance {

    void setup(OWLModelManager manager, String type);

    void doSomething();
}
