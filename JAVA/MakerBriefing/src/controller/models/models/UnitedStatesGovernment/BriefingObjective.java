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

import java.util.ArrayList;
import model.UnitedStatesGovernment.Briefing;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class BriefingObjective {
    private controller.models.models.UnitedStatesGovernment.Briefing controllerBriefing;
    private view.models.UnitedStatesGovernment.BriefingObjective view = new view.models.UnitedStatesGovernment.BriefingObjective();

    BriefingObjective(controller.models.models.UnitedStatesGovernment.Briefing controllerBriefing) {
        this.controllerBriefing = controllerBriefing;
    }
    
    public void setVisible(boolean state) {
        view.setVisible(state);
    }
    
    void centerOnWindow(view.models.UnitedStatesGovernment.Briefing view) {
        this.view.setLocationRelativeTo(view);
    }
    void loadObjective(ArrayList<Briefing.Objective> objectives, int i) {
    
    }
}
