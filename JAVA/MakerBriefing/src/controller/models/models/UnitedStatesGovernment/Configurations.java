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
package controller.models.models.UnitedStatesGovernment;

import controller.models.UnitedStatesGovernment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class Configurations {
    private UnitedStatesGovernment controllerMain;
    private view.models.UnitedStatesGovernment.Configurations view = new view.models.UnitedStatesGovernment.Configurations(this);
    private JButton btnWriteBriefing;
    
    public Configurations(UnitedStatesGovernment controlerMain) {
        this.controllerMain = controlerMain;
    }
    
    public void setVisible(boolean state) {
        view.setVisible(state);
    }
    
    public void centerOnScreen() {
        view.setLocationRelativeTo(null);
    }

    public void setBtnWriteBriefing(JButton btnWriteBriefing) {
        this.btnWriteBriefing = btnWriteBriefing;
    }
    
    public void btnBackToPanel() {
        setVisible(false);
        controllerMain.getPrepareTemplate().setVisible(true);
    }

    public void btnSetName(JTextField textField) {
        if (textField.getText() != null && textField.getText().length() > 0) {
            controllerMain.loadConfig_missionName(textField.getText());
        } else {
            JOptionPane.showMessageDialog(view, "First write the mission's name.", "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
