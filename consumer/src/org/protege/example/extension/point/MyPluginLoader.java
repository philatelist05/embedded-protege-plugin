package org.protege.example.extension.point;

import org.eclipse.core.runtime.IExtension;
import org.protege.editor.core.plugin.AbstractPluginLoader;
import org.protege.editor.core.plugin.DefaultPluginExtensionMatcher;
import org.protege.editor.core.plugin.PluginExtensionMatcher;
import org.protege.editor.owl.model.OWLModelManager;

public class MyPluginLoader extends AbstractPluginLoader<MyPlugin> {

    private OWLModelManager owlModelManager;

    public MyPluginLoader(final OWLModelManager owlModelManager) {
        super(MyPlugin.CONSUMER_ID, MyPlugin.ID);
        this.owlModelManager = owlModelManager;
    }

    @Override
    protected PluginExtensionMatcher getExtensionMatcher() {
        return new DefaultPluginExtensionMatcher();
    }

    @Override
    protected MyPlugin createInstance(final IExtension extension) {
        return new MyPlugin(owlModelManager, extension);
    }
}
