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
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class Briefing {
    private final UnitedStatesGovernment controlerMain;
    private final view.models.UnitedStatesGovernment.Briefing view = new view.models.UnitedStatesGovernment.Briefing(this);
    private final controller.models.models.UnitedStatesGovernment.BriefingObjective controllerObjective = new controller.models.models.UnitedStatesGovernment.BriefingObjective(this);
    
    public Briefing (UnitedStatesGovernment controlerMain) {
        this.controlerMain = controlerMain;
    }
    
    public void setVisible(boolean state) {
        view.setVisible(state);
    }
    
    public void centerOnScreen() {
        view.setLocationRelativeTo(null);
    }

    public void loadBriefing(int pos) {
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }

    public void btnBackToPanel() {
        view.setVisible(false);
        controlerMain.getPrepareTemplate().setVisible(true);
        controlerMain.exportVerification();
    }

    public void btnPrevious(int pos) {
        view.loadBriefing(controlerMain.getModelBriefing(), (pos - 2));
    }

    public void btnNext(int pos) {
        if (pos == controlerMain.getModelBriefing().size()) {
            controlerMain.getModelBriefing().add(new model.UnitedStatesGovernment.Briefing());
            view.loadBriefing(controlerMain.getModelBriefing(), (controlerMain.getModelBriefing().size() - 1));
        } else {
            view.loadBriefing(controlerMain.getModelBriefing(), pos);
        }
    }

    public void btnEliminate(int pos) {
        controlerMain.getModelBriefing().remove(pos);
        if (controlerMain.getModelBriefing().isEmpty()) {
            btnBackToPanel();
        } else {
            if (pos == controlerMain.getModelBriefing().size()) {
                view.loadBriefing(controlerMain.getModelBriefing(), (pos - 1));
            } else {
                view.loadBriefing(controlerMain.getModelBriefing(), pos);
            }
        }
    }

    public void btnSave(int pos) {
        if (view.getjTextField3().getText() != null && view.getjTextField3().getText().length() > 0) 
            controlerMain.getModelBriefing().get(pos).setNav(view.getjTextField3().getText());
        if (view.getjTextField4().getText() != null && view.getjTextField4().getText().length() > 0) 
            controlerMain.getModelBriefing().get(pos).setTitle(view.getjTextField4().getText());
        if (view.getjTextField6().getText() != null && view.getjTextField6().getText().length() > 0) 
            controlerMain.getModelBriefing().get(pos).getDescription().setTime(view.getjTextField6().getText());
        if (view.getjTextField7().getText() != null && view.getjTextField7().getText().length() > 0) 
            controlerMain.getModelBriefing().get(pos).getDescription().setReceiver(view.getjTextField7().getText());
        if (view.getjTextField8().getText() != null && view.getjTextField8().getText().length() > 0) 
            controlerMain.getModelBriefing().get(pos).getDescription().setSender(view.getjTextField8().getText());
        if (view.getjTextArea1().getText() != null && view.getjTextArea1().getText().length() > 0)
            controlerMain.getModelBriefing().get(pos).getDescription().setDescription(view.getjTextArea1().getText());
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }

    public void btnSelectImage(int pos) {
        JFileChooser fileChooser = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fileChooser.addChoosableFileFilter(imageFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int selecction = fileChooser.showOpenDialog(view);
        if (selecction == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            controlerMain.getModelBriefing().get(pos).setMap(file);
            controlerMain.getModelBriefing().get(pos).setHeightMapImages(720);
            btnSave(pos);
            view.loadBriefing(controlerMain.getModelBriefing(), pos);
        }
    }

    public void btnCheck_title(int pos) {
        controlerMain.getModelBriefing().get(pos).setTitle(null);
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }

    public void btnCheck_map(int pos) {
        controlerMain.getModelBriefing().get(pos).setMap(null);
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }

    public void btnCheck_time(int pos) {
        controlerMain.getModelBriefing().get(pos).getDescription().setTime(null);
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }

    public void btnCheck_receiver(int pos) {
        controlerMain.getModelBriefing().get(pos).getDescription().setReceiver(null);
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }

    public void btnCheck_sender(int pos) {
        controlerMain.getModelBriefing().get(pos).getDescription().setSender(null);
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }

    public void btnCheck_description(int pos) {
        controlerMain.getModelBriefing().get(pos).getDescription().setDescription(null);
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }

    public void btnInspectObjectives(int pos) {
        controllerObjective.setVisible(true);
        controllerObjective.centerOnWindow(view);
        controllerObjective.loadObjective(controlerMain.getModelBriefing().get(0).getObjectives(), 0);
    }
}
