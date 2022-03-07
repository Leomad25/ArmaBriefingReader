/*
 * Copyright (C) 2022 Leonardo Miguel Aguado Diaz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package controller;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class Main {
    private view.Main view = new view.Main(this);

    public void setVisible(boolean state) {
        view.setVisible(state);
    }
    
    public void centerOnScreen() {
        view.setLocationRelativeTo(null);
    }
    
    public void btnCreateNewBreafing(int selectedIndex) {
        setVisible(false);
        controller.PrepareTemplate prepareTemplate = new PrepareTemplate(selectedIndex);
        prepareTemplate.setVisible(true);
        prepareTemplate.centerOnScreen();
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
        main.centerOnScreen();
    }
}
