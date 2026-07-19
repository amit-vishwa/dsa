package module.three.lld.patterns.creational;

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering windows button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering windows checkbox");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering mac button");
    }
}


class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering mac checkbox");
    }
}

interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory guiFactory) {
        this.button = guiFactory.createButton();
        this.checkbox = guiFactory.createCheckbox();
    }

    public void render() {
        this.button.render();
        this.checkbox.render();
    }
}

/**
 * Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
 */
public class _4AbstractFactory {

    public static void main(String[] args) {
        Application windowsApplication = new Application(new WindowsFactory());
        Application macApplication = new Application(new MacFactory());
        windowsApplication.render();
        macApplication.render();
    }

}
