package es.fron99.foodorganize.Models;

public class Menu {

    private String nameMenu;
    private String smallDescriptionMenu;

    public Menu() {
        this.nameMenu = "nameMenu";
        this.smallDescriptionMenu = "smaillDescriptionMenu";
    }

    public Menu(String nameMenu, String smallDescriptionMenu) {
        this.nameMenu = nameMenu;
        this.smallDescriptionMenu = smallDescriptionMenu;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public String getSmallDescriptionMenu() {
        return smallDescriptionMenu;
    }

    public void setSmallDescriptionMenu(String smallDescriptionMenu) {
        this.smallDescriptionMenu = smallDescriptionMenu;
    }
}
