package view;

import java.util.Arrays;

public class MenuComponent extends AbstractComponent<Void> {

    public MenuComponent() {
        super(ComponentType.MENU, null);
    }

    @Override
    public void draw() {
        System.out.println("****** MENU ******");
        Arrays.stream(ComponentType.values())
                .map(v -> v.getType() + " " + v.getComment())
                .forEach(System.out::println);
        System.out.println("9 - Exit\n");
    }
}
