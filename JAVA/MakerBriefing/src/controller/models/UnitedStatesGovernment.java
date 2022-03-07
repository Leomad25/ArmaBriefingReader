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
import java.util.List;
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
    private List<model.UnitedStatesGovernment.Briefing> modelBriefing;
    private model.UnitedStatesGovernment.Configurations modelConfigurations = new model.UnitedStatesGovernment.Configurations();

    public UnitedStatesGovernment(PrepareTemplate prepareTemplate) {
        this.prepareTemplate =  prepareTemplate;
        loadDefaultModelConfigurations();
    }

    public List<model.UnitedStatesGovernment.Briefing> getModelBriefing() {
        return modelBriefing;
    }

    public model.UnitedStatesGovernment.Configurations getModelConfigurations() {
        return modelConfigurations;
    }
    
    public PrepareTemplate getPrepareTemplate () {
        return prepareTemplate;
    }
    
    private void loadDefaultModelConfigurations() {
        // Login From
        modelConfigurations.getLoginForm().setTitle("Red Lobo Blanco");
        modelConfigurations.getLoginForm().setBtnLoginTag("Iniciar sesión");
        modelConfigurations.getLoginForm().setBtnSkipToPanel("Ir al panel");
        modelConfigurations.getLoginForm().setUser("Lobo Blanco");
        modelConfigurations.getLoginForm().setPass("Destacamento");
        // Top Secret
        modelConfigurations.getTopSecret().setTag("Top Secret");
        // Tag webs
        modelConfigurations.getWebTags().setHeaderTitle("Lobo Blanco - Brief");
        modelConfigurations.getWebTags().setPanelObjectiveTag("Objetivos");
        // Nav size tags
        modelConfigurations.setNavSize(90);
        // background Color
        modelConfigurations.getBackgroundColorTop().setBlue(10);
        modelConfigurations.getBackgroundColorTop().setAlpha(1);
        modelConfigurations.getBackgroundColorBottom().setBlue(100);
        modelConfigurations.getBackgroundColorBottom().setAlpha(1);
    }

    @Override
    public void btnSetConfigurations(JButton btnWriteBriefing) {
        prepareTemplate.setVisible(false);
        viewConfigurations.setVisible(true);
        viewConfigurations.centerOnScreen();
        if (modelConfigurations.getTopSecret().getOperationName() != null && modelConfigurations.getTopSecret().getOperationName().length() > 0) {
            viewConfigurations.loadModel();
        } else {
            viewConfigurations.setBtnWriteBriefing(btnWriteBriefing);
        }
    }

    @Override
    public void btnWriteBriefing(JButton btnPreview, JButton btnExport) {
        prepareTemplate.setVisible(false);
    }

    @Override
    public void btnPreview() {
        
    }

    @Override
    public void btnExport() {
        
    }

    public void loadConfig_missionName(String text) {
        modelConfigurations.getTopSecret().setOperationName(text);
        modelConfigurations.getWebTags().setHeaderSubTitle(text);
    }
}
