package org.protege.example.extension.point;

import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.AbstractProtegePlugin;
import org.protege.editor.owl.model.OWLModelManager;
import org.protege.example.extension.point.api.MyPluginInstance;

public class MyPlugin extends AbstractProtegePlugin<MyPluginInstance> {

    public static final String TYPE_PARAM = "type";
    public static final String CONSUMER_ID = "org.protege.example.extension.point";
    public static final String ID = "custom_extension_point";
    
    private OWLModelManager modelManager;
    
    public MyPlugin(final OWLModelManager modelManager, final IExtension extension) {
    	super(extension);
        this.modelManager = modelManager;
    }

    /**
     * gets the declared type field for the plugin
     */
    public String getType() {
        return getPluginProperty(TYPE_PARAM, "null type");
    }

    /**
     * Creates an instance of the plugin.  It is expected that
     * this instance will be "setup", but the instance's
     * initialise method will not have been called in the instantiation
     * process.
     */
    @Override
    public MyPluginInstance newInstance() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    	MyPluginInstance mpi = super.newInstance();
        mpi.setup(modelManager, getType());
        return mpi;
    }
}
