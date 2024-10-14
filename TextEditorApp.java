import java.util.HashMap;
import java.util.Map;

// Character class
class Character {
    private char value;
    private String font;
    private int size;

    public Character(char value, String font, int size) {
        this.value = value;
        this.font = font;
        this.size = size;
    }

    public void render(int x, int y) {
        System.out.println("Rendering character " + value + " at (" + x + ", " + y + ") with font " + font + " and size " + size);
    }
}

class CharacterFactory {
    private Map<String, Character> characterMap = new HashMap<>();

    public Character getCharacter(char value, String font, int size) {
        String key = value + font + size;
        if (!characterMap.containsKey(key)) {
            characterMap.put(key, new Character(value, font, size));
        }
        return characterMap.get(key);
    }
}

class TextEditor {
    private CharacterFactory factory;
    private Map<Integer, Character> textMap = new HashMap<>();

    public TextEditor(CharacterFactory factory) {
        this.factory = factory;
    }

    public void insertCharacter(int position, char value, String font, int size) {
        textMap.put(position, factory.getCharacter(value, font, size));
    }

    public void render() {
        for (Map.Entry<Integer, Character> entry : textMap.entrySet()) {
            entry.getValue().render(entry.getKey(), 0); // Render at Y = 0 for simplicity
        }
    }
}

// TextEditorApp class
class TextEditorApp {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        TextEditor editor = new TextEditor(factory);

        editor.insertCharacter(1, 'H', "Arial", 12);
        editor.insertCharacter(2, 'e', "Arial", 12);
        editor.insertCharacter(3, 'l', "Arial", 12);
        editor.insertCharacter(4, 'l', "Arial", 12);
        editor.insertCharacter(5, 'o', "Arial", 12);

        editor.render();
    }
}
