package studentorganizer;

import javax.swing.*;
import java.awt.*;

public class CheckboxRenderer extends JCheckBox implements ListCellRenderer<ChecklistItem> {

    @Override
    public Component getListCellRendererComponent(JList<? extends ChecklistItem> list, ChecklistItem value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setText(value.getText());
        setSelected(value.isSelected());

        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());

        return this;
    }
}
