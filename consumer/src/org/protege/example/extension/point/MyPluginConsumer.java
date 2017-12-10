package org.protege.example.extension.point;

import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;
import org.protege.editor.owl.ui.action.ProtegeOWLAction;
import org.protege.example.extension.point.api.MyPluginInstance;

public class MyPluginConsumer extends ProtegeOWLAction {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(MyPluginConsumer.class);

    @Override
    public void initialise() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        MyPluginLoader loader = new MyPluginLoader(getOWLModelManager());
        for (MyPlugin plugin : loader.getPlugins()) {
            try {
                MyPluginInstance i = plugin.newInstance();
                i.doSomething();
            }
            catch (Exception ex) {
                logger.error("Could not instantiate Plugin " + plugin, ex);
            }
        }
    }
}
