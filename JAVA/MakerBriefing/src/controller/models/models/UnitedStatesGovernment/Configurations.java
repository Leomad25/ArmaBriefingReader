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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
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
    
    public void loadModel() {
        view.loadModelCofigurations(controllerMain.getModelConfigurations());
    }
    
    public void btnBackToPanel() {
        setVisible(false);
        controllerMain.getPrepareTemplate().setVisible(true);
    }

    public void btnSetName(JTextField textField) {
        if (textField.getText() != null && textField.getText().length() > 0) {
            controllerMain.loadConfig_missionName(textField.getText());
            view.loadModelCofigurations(controllerMain.getModelConfigurations());
            btnWriteBriefing.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(view, "First write the mission's name.", "Error.", JOptionPane.ERROR_MESSAGE);
            if (controllerMain.getModelConfigurations().getTopSecret().getOperationName().length() > 0) {
                view.loadModelCofigurations(controllerMain.getModelConfigurations());
            }
        }
    }
    
    public void btnSetColors(JSpinner top_red, JSpinner top_green, JSpinner top_blue, JSpinner bottom_red, JSpinner bottom_green, JSpinner bottom_blue) {
        if (((int) top_red.getValue()) < 0) { top_red.setValue(0); } else if (((int) top_red.getValue()) > 255) { top_red.setValue(255); }
        if (((int) top_green.getValue()) < 0) { top_green.setValue(0); } else if (((int) top_green.getValue()) > 255) { top_green.setValue(255); }
        if (((int) top_blue.getValue()) < 0) { top_blue.setValue(0); } else if (((int) top_blue.getValue()) > 255) { top_blue.setValue(255); }
        if (((int) bottom_red.getValue()) < 0) { bottom_red.setValue(0); } else if (((int) bottom_red.getValue()) > 255) { bottom_red.setValue(255); }
        if (((int) bottom_green.getValue()) < 0) { bottom_green.setValue(0); } else if (((int) bottom_green.getValue()) > 255) { bottom_green.setValue(255); }
        if (((int) bottom_blue.getValue()) < 0) { bottom_blue.setValue(0); } else if (((int) bottom_blue.getValue()) > 255) { bottom_blue.setValue(255); }
        controllerMain.getModelConfigurations().getBackgroundColorTop().setRed((int) top_red.getValue());
        controllerMain.getModelConfigurations().getBackgroundColorTop().setGreen((int) top_green.getValue());
        controllerMain.getModelConfigurations().getBackgroundColorTop().setBlue((int) top_blue.getValue());
        controllerMain.getModelConfigurations().getBackgroundColorBottom().setRed((int) bottom_red.getValue());
        controllerMain.getModelConfigurations().getBackgroundColorBottom().setGreen((int) bottom_green.getValue());
        controllerMain.getModelConfigurations().getBackgroundColorBottom().setBlue((int) bottom_blue.getValue());
        JOptionPane.showMessageDialog(view, "Color background saved.", "Successful", JOptionPane.INFORMATION_MESSAGE);
        view.loadModelCofigurations(controllerMain.getModelConfigurations());
    }

    public void btnSetLabels(JTextField jTextField2, JTextField jTextField3, JTextField jTextField4, JTextField jTextField5, JTextField jTextField6, JTextField jTextField7, JTextField jTextField8, JTextField jTextField9, JTextField jTextField10, JTextField jTextField11) {
        boolean saveStorage = true;
        if (jTextField2.getText() == null || jTextField2.getText().length() == 0) { jTextField2.setBackground(Color.red); saveStorage = false; }
        if (jTextField3.getText() == null || jTextField3.getText().length() == 0) { jTextField3.setBackground(Color.red); saveStorage = false; }
        if (jTextField4.getText() == null || jTextField4.getText().length() == 0) { jTextField4.setBackground(Color.red); saveStorage = false; }
        if (jTextField5.getText() == null || jTextField5.getText().length() == 0) { jTextField5.setBackground(Color.red); saveStorage = false; }
        if (jTextField6.getText() == null || jTextField6.getText().length() == 0) { jTextField6.setBackground(Color.red); saveStorage = false; }
        if (jTextField7.getText() == null || jTextField7.getText().length() == 0) { jTextField7.setBackground(Color.red); saveStorage = false; }
        if (jTextField8.getText() == null || jTextField8.getText().length() == 0) { jTextField8.setBackground(Color.red); saveStorage = false; }
        if (jTextField9.getText() == null || jTextField9.getText().length() == 0) { jTextField9.setBackground(Color.red); saveStorage = false; }
        if (jTextField10.getText() == null || jTextField10.getText().length() == 0) { jTextField10.setBackground(Color.red); saveStorage = false; }
        if (jTextField11.getText() == null || jTextField11.getText().length() == 0) { jTextField11.setBackground(Color.red); saveStorage = false; }
        if (saveStorage) {
            controllerMain.getModelConfigurations().getLoginForm().setTitle(jTextField2.getText());
            controllerMain.getModelConfigurations().getLoginForm().setBtnLoginTag(jTextField3.getText());
            controllerMain.getModelConfigurations().getLoginForm().setBtnSkipToPanel(jTextField4.getText());
            controllerMain.getModelConfigurations().getLoginForm().setUser(jTextField5.getText());
            controllerMain.getModelConfigurations().getLoginForm().setPass(jTextField6.getText());
            controllerMain.getModelConfigurations().getTopSecret().setTag(jTextField7.getText());
            controllerMain.getModelConfigurations().getTopSecret().setOperationName(jTextField8.getText());
            controllerMain.getModelConfigurations().getWebTags().setHeaderTitle(jTextField9.getText());
            controllerMain.getModelConfigurations().getWebTags().setHeaderSubTitle(jTextField10.getText());
            controllerMain.getModelConfigurations().getWebTags().setPanelObjectiveTag(jTextField11.getText());
            JOptionPane.showMessageDialog(view, "Fields storaged.", "Successful", JOptionPane.INFORMATION_MESSAGE);
            view.loadModelCofigurations(controllerMain.getModelConfigurations());
        } else {
            JOptionPane.showMessageDialog(view, "No field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setDefauldColorsToLabes(JTextField jTextField) {
        jTextField.setBackground(Color.WHITE);
    }

    public void btnSetNavSize(JSpinner jSpinner) {
        if (((int) jSpinner.getValue()) < 50) { jSpinner.setValue(50); } else if (((int) jSpinner.getValue()) > 200) { jSpinner.setValue(200); }
        controllerMain.getModelConfigurations().setNavSize((int) jSpinner.getValue());
        JOptionPane.showMessageDialog(view, "Nav size saved.", "Successful", JOptionPane.INFORMATION_MESSAGE);
        view.loadModelCofigurations(controllerMain.getModelConfigurations());
    }
}
