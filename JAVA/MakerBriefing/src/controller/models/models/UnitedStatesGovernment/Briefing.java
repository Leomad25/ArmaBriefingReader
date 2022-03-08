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

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class Briefing {
    private final UnitedStatesGovernment controlerMain;
    private final view.models.UnitedStatesGovernment.Briefing view = new view.models.UnitedStatesGovernment.Briefing(this);
    
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
        view.loadBriefing(controlerMain.getModelBriefing(), pos);
    }
}
