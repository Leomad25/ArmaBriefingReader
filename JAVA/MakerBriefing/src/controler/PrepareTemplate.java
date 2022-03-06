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
package controler;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class PrepareTemplate {
    private int templateIndex;
    private view.PrepareTemplate view = new view.PrepareTemplate(this);
    
    // Tempates
    private controler.models.UnitedStatesGovernment controlerUnitedStatesGovernment = new controler.models.UnitedStatesGovernment(this);

    // Methos
    public PrepareTemplate(int templateIndex) {
        this.templateIndex = templateIndex;
    }
    
    public void setVisible(boolean state) {
        view.setVisible(state);
    }
    
    public void centerOnScreen() {
        view.setLocationRelativeTo(null);
    }

    public void templateLabel(JTextField jTextField1) {
        String[] labels = {
            "United States Government"
        };
        jTextField1.setText(labels[templateIndex]);
    }

    public void btnSetConfigurations(JButton btnWriteBriefing) {
        if (templateIndex == 0) controlerUnitedStatesGovernment.btnSetConfigurations(btnWriteBriefing);
    }
    
}
