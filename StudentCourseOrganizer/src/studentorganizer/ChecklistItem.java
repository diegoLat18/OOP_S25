package studentorganizer;

public class ChecklistItem {
    private String text;
    private boolean selected;

    public ChecklistItem(String text) {
        this.text = text;
        this.selected = false; //  this is to starting the check box for assingment unchecked
    }

    public String getText() {
        return text;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return text;
    }
}

