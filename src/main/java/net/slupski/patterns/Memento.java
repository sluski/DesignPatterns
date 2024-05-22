package net.slupski.patterns;

import java.util.Deque;
import java.util.LinkedList;
import net.slupski.patterns.TextArea.Snapshot;

public class Memento extends Pattern {

    @Override
    void example() {
        var editor = new Editor();
        editor.write("");
        editor.write("This");
        editor.write("This is");
        editor.write("This is design");
        System.out.println("This is design pattern");
        
        editor.undo();
        printText(editor);
        
        editor.undo();
        printText(editor);
        
        editor.undo();
        printText(editor);
        
        editor.undo();
        printText(editor);
        
        editor.undo();
    }
    
    private void printText(Editor editor) {
        System.out.println(editor.read());
    }
    
}

class TextArea {
       
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
    
    class Editor {
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
            System.out.println("Undo...");
            if(stateHistory.isEmpty()) {
                System.out.println("Nothing to undo");
                return;
            }
            textArea.restore(stateHistory.pollLast());
        }
         
    }
