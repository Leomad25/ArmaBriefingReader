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
package templates;

import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class TemplatesManager {
    Class thisClass = TemplatesManager.class;
    
    public InputStream getUnitedStatesGovernment() {
        return thisClass.getResourceAsStream("UnitedStatesGovernment.html");
    }
    
    public InputStream getLogoImage() {
        return thisClass.getResourceAsStream("images/logo.png");
    }
    
    public static ImageIcon getLogoImageIcon80() {
        ImageIcon icon = new ImageIcon(new templates.TemplatesManager().thisClass.getResource("/templates/images/logo_80.png"));
        return  icon;
    }
    
    public static ImageIcon getLogoImageIcon30() {
        ImageIcon icon = new ImageIcon(new templates.TemplatesManager().thisClass.getResource("/templates/images/logo_30.png"));
        return  icon;
    }
}
