package net.slupski.patterns;

import java.util.Deque;
import java.util.LinkedList;
import net.slupski.patterns.Memento.TextArea.Snapshot;

public class Memento extends Pattern {

    @Override
    void example() {
        var editor = new Editor();
        editor.write("This");
        editor.write("This is");
        editor.write("This is design");
        editor.write("This is design pattern");
        editor.read();
        
        editor.undo();
        editor.read();
        
        editor.undo();
        editor.read();
        
        editor.undo();
        editor.read();
        
        editor.undo();
        editor.read();
    }
    
    
    static class TextArea {
       
        private String text;
        
        public TextArea() {
            text = "";
        }
        
        public void set(String text) {
            this.text = text;
        }
        
        public Snapshot takeSnaposhot() {
            return new Snapshot(text);
        }

        public void restore(Snapshot snapshot) {
            this.text = snapshot.getSavedText();
        }
        
        public String getText() {
            return text;
        }
        
    
        static class Snapshot {
            private final String text;

            public Snapshot(String text) {
                this.text = text;
            }
            
            private String getSavedText() {
                return text;
            }
        }
    }
    
    static class Editor {
        private Deque<Snapshot> stateHistory;
        private TextArea textArea;
        
        public Editor() {
            stateHistory = new LinkedList<>();
            textArea = new TextArea();
        }
        
        public void write(String text) {
            textArea.set(text);
            stateHistory.add(textArea.takeSnaposhot());
        }
        
        public String read() {
            return textArea.getText();
        }
        
        public void undo() {
            textArea.restore(stateHistory.pop());
        }
         
    }
}
