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

import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.UnitedStatesGovernment.Briefing;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class BriefingObjective {
    private controller.models.models.UnitedStatesGovernment.Briefing controllerBriefing;
    private view.models.UnitedStatesGovernment.BriefingObjective view = new view.models.UnitedStatesGovernment.BriefingObjective(this);
    private int briefingIndex;

    BriefingObjective(controller.models.models.UnitedStatesGovernment.Briefing controllerBriefing) {
        this.controllerBriefing = controllerBriefing;
    }
    
    public void setVisible(boolean state) {
        view.setVisible(state);
    }
    
    void centerOnWindow(view.models.UnitedStatesGovernment.Briefing view) {
        this.view.setLocationRelativeTo(view);
    }
    
    void loadObjective(ArrayList<Briefing.Objective> objectives, int pos) {
        view.loadObjective(objectives, pos);
    }
    
    public void loadBriefingIndex(int pos) {
        view.loadBriefingIndex(pos + 1);
        briefingIndex = pos;
    }

    public controller.models.models.UnitedStatesGovernment.Briefing getControllerBriefing() {
        return controllerBriefing;
    }

    public void btnBackToPanel() {
        view.setVisible(false);
    }

    public void btnPrevious(int pos) {
        loadObjective(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives(), (pos - 1));
    }

    public void btnDelete(int pos) {
        controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().remove(pos);
        if (controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().isEmpty()) {
            btnBackToPanel();
            controllerBriefing.loadBriefing(briefingIndex);
        } else {
            if (pos == controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().size()) {
                loadObjective(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives(), (pos - 1));
            } else {
                loadObjective(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives(), pos);
            }
        }
    }

    public void btnNext(int pos) {
        if (pos == (controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().size() - 1)) {
            controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().add(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).createObjetive());
            loadObjective(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives(), (pos + 1));
            controllerBriefing.loadBriefing(briefingIndex);
        } else {
            loadObjective(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives(), (pos + 1));
        }
    }

    public void btnSave(int pos, JTextArea textArea, JButton buttom) {
        if (buttom.isEnabled()) {
            controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().get(pos).setDescription(removeLineBreak(textArea.getText()));
            loadObjective(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives(), pos);
        }
    }

    public void btnAddImage(int pos) {
        JFileChooser fileChooser = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fileChooser.addChoosableFileFilter(imageFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int selecction = fileChooser.showOpenDialog(view);
        if (selecction == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().get(pos).getImages().add(file);
        }
        loadObjective(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives(), pos);
    }

    public void btnDeleteImage(int pos, int selectedIndex) {
        controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().get(pos).getImages().remove(selectedIndex);
        loadObjective(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives(), pos);
    }

    public void selectedImage(JButton button) {
        button.setEnabled(true);
    }

    public void writeOnDescription(int pos, JTextArea textArea, JButton buttom) {
        if (controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().get(pos).getDescription() == null) {
            if (textArea.getText().length() > 0) {
                buttom.setEnabled(true);
                return;
            }
        } else {
            if (textArea.getText().length() > 0) {
                if (!textArea.getText().equals(controllerBriefing.getControllerMain().getModelBriefing().get(briefingIndex).getObjectives().get(pos).getDescription())) {
                    buttom.setEnabled(true);
                    return;
                }
            }
        }
        buttom.setEnabled(false);
    }
    
    private String removeLineBreak(String text) {
        String str = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != '\n') str += c;
        }
        return str;
    }
}
