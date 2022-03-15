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
import java.util.ArrayList;
import model.UnitedStatesGovernment.Briefing;
import model.UnitedStatesGovernment.Configurations;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class Preview {
    private UnitedStatesGovernment controlerMain;
    private view.models.UnitedStatesGovernment.Preview view = new view.models.UnitedStatesGovernment.Preview(this);
    
    public Preview(UnitedStatesGovernment controlerMain) {
        this.controlerMain = controlerMain;
    }

    public void setVisible(boolean state) {
        view.setVisible(state);
    }
    
    public void centerOnScreen() {
        view.setLocationRelativeTo(null);
    }

    public void btnBackToPanel() {
        view.setVisible(false);
        controlerMain.getPrepareTemplate().setVisible(true);
    }

    public void btnExport() {
        btnBackToPanel();
        controlerMain.startExport();
    }

    public void btnConfigurationsEdit() {
        view.setVisible(false);
        controlerMain.getViewConfigurations().setVisible(true);
    }

    public void btnBriefingEdit(int pos) {
        view.setVisible(false);
        controlerMain.getViewBriefing().setVisible(true);
        controlerMain.getViewBriefing().loadBriefing(pos);
    }

    public void btnBriefingPrevious(int pos) {
        view.loadBriefing(controlerMain.getModelBriefing(), (pos - 1));
        view.loadObjective(controlerMain.getModelBriefing().get(pos - 1).getObjectives(), 0);
    }

    public void btnBriefingNext(int pos) {
        view.loadBriefing(controlerMain.getModelBriefing(), (pos + 1));
        view.loadObjective(controlerMain.getModelBriefing().get(pos + 1).getObjectives(), 0);
    }

    public void btnBriefingObjectivePrevious(int pos, int pos2) {
        view.loadObjective(controlerMain.getModelBriefing().get(pos).getObjectives(), pos2 - 1);
    }

    public void btnBriefingObjectiveNext(int pos, int pos2) {
        view.loadObjective(controlerMain.getModelBriefing().get(pos).getObjectives(), pos2 + 1);
    }
    
    public void loadExport() {
        view.loadExport(controlerMain.isExportEnable());
    }
    
    public void loadConfigurations(Configurations modelConfigurations, ArrayList<Briefing> modelBriefing) {
        view.loadConfigurations(modelConfigurations, modelBriefing);
        loadExport();
    }

    public void loadBriefing(ArrayList<Briefing> modelBriefing, int pos) {
        view.loadBriefing(modelBriefing, pos);
        view.loadObjective(modelBriefing.get(pos).getObjectives(), 0);
    }
}
