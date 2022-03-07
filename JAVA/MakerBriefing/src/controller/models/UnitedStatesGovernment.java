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
package controller.models;

import controller.PrepareTemplate;
import controller.models.models.UnitedStatesGovernment.Briefing;
import controller.models.models.UnitedStatesGovernment.Configurations;
import controller.models.models.UnitedStatesGovernment.Preview;
import javax.swing.JButton;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class UnitedStatesGovernment implements model.interfaces.templates {
    private PrepareTemplate prepareTemplate;
    // Views
    private Briefing viewBriefing = new Briefing(this);
    private Configurations viewConfigurations = new Configurations(this);
    private Preview viewPreview = new Preview(this);
    // Models
    private model.UnitedStatesGovernment.Briefing modelBriefing = new model.UnitedStatesGovernment.Briefing();
    private model.UnitedStatesGovernment.Configurations modelConfigurations = new model.UnitedStatesGovernment.Configurations();

    public UnitedStatesGovernment(PrepareTemplate prepareTemplate) {
        this.prepareTemplate =  prepareTemplate;
    }
    
    public PrepareTemplate getPrepareTemplate () {
        return prepareTemplate;
    }

    @Override
    public void btnSetConfigurations(JButton btnWriteBriefing) {
        prepareTemplate.setVisible(false);
        viewConfigurations.setVisible(true);
        viewConfigurations.centerOnScreen();
        viewConfigurations.setBtnWriteBriefing(btnWriteBriefing);
    }

    @Override
    public void btnWriteBriefing(JButton btnPreview, JButton btnExport) {
        
    }

    @Override
    public void btnPreview() {
        
    }

    @Override
    public void btnExport() {
        
    }

    public void loadConfig_missionName(String text) {
        System.out.println("test to load");
    }
}
