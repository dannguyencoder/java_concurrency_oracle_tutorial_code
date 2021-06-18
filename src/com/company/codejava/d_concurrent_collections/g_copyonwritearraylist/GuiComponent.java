package com.company.codejava.d_concurrent_collections.g_copyonwritearraylist;

import javafx.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * This program demonstrates how CopyOnWriteArrayList is used.
 *
 * @author www.codejava.net
 */
class GuiComponent {
    private List<ActionListener> listeners = new CopyOnWriteArrayList<>();

    public void addActionListener(ActionListener listener) {
        listeners.add(listener);
    }

    public void removeActionListener(ActionListener listener) {
        listeners.remove(listener);
    }

    public void fireActionEvent() {
        for (ActionListener listener : listeners) {
//            listener.actionPerformed(new ActionEvent(this, "message"));
        }
    }
}
