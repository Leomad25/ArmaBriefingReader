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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import templates.TemplatesManager;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class UnitedStatesGovernment implements model.interfaces.templates {
    private final PrepareTemplate prepareTemplate;
    // Views
    private final Briefing viewBriefing = new Briefing(this);
    private final Configurations viewConfigurations = new Configurations(this);
    private final Preview viewPreview = new Preview(this);
    // Models
    private final ArrayList<model.UnitedStatesGovernment.Briefing> modelBriefing = new ArrayList<>();
    private final model.UnitedStatesGovernment.Configurations modelConfigurations = new model.UnitedStatesGovernment.Configurations();

    public UnitedStatesGovernment(PrepareTemplate prepareTemplate) {
        this.prepareTemplate =  prepareTemplate;
        loadDefaultModelConfigurations();
    }

    public ArrayList<model.UnitedStatesGovernment.Briefing> getModelBriefing() {
        return modelBriefing;
    }

    public model.UnitedStatesGovernment.Configurations getModelConfigurations() {
        return modelConfigurations;
    }

    public Briefing getViewBriefing() {
        return viewBriefing;
    }

    public Configurations getViewConfigurations() {
        return viewConfigurations;
    }

    public Preview getViewPreview() {
        return viewPreview;
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
    public void btnWriteBriefing() {
        prepareTemplate.setVisible(false);
        viewBriefing.setVisible(true);
        viewBriefing.centerOnScreen();
        if (modelBriefing.isEmpty()) {
            modelBriefing.add(new model.UnitedStatesGovernment.Briefing());
        }
        viewBriefing.loadBriefing(0);
    }
    
    @Override
    public void btnPreview() {
        prepareTemplate.setVisible(false);
        viewPreview.setVisible(true);
        viewPreview.centerOnScreen();
        viewPreview.loadConfigurations(modelConfigurations, modelBriefing);
        viewPreview.loadBriefing(modelBriefing, 0);
    }

    @Override
    public void btnExport() {
        startExport();
    }

    public void loadConfig_missionName(String text) {
        modelConfigurations.getTopSecret().setOperationName(text);
        modelConfigurations.getWebTags().setHeaderSubTitle(text);
    }
    
    public void fixBriefing() {
        if (!modelBriefing.isEmpty()) {
            for (int i = 0; i < modelBriefing.size(); i++) {
                if (!modelBriefing.get(i).getObjectives().isEmpty()) {
                    for (int i2 = 0; i2 < modelBriefing.get(i).getObjectives().size(); i2++) {
                        if (modelBriefing.get(i).getObjectives().get(i2).getDescription() == null && modelBriefing.get(i).getObjectives().get(i2).getImages().isEmpty())
                            modelBriefing.get(i).getObjectives().remove(i2);
                    }
                }
            }
            for (int i = 0; i < modelBriefing.size(); i++) {
                if (
                    modelBriefing.get(i).getNav() == null &&
                    modelBriefing.get(i).getTitle() == null &&
                    modelBriefing.get(i).getMap() == null &&
                    modelBriefing.get(i).getDescription().getTime() == null &&
                    modelBriefing.get(i).getDescription().getReceiver() == null &&
                    modelBriefing.get(i).getDescription().getSender() == null &&
                    modelBriefing.get(i).getDescription().getDescription() == null &&
                    modelBriefing.get(i).getObjectives().isEmpty()
                        
                ) modelBriefing.remove(i);
            }
        }
        previewEnable();
        exportEnable();
    }
    
    public void previewEnable() {
        if (!modelBriefing.isEmpty()) {
            prepareTemplate.getBtnPreview().setEnabled(true);
        } else {
            prepareTemplate.getBtnPreview().setEnabled(false);
        }
    }
    
    public boolean isExportEnable() {
        boolean enable = true;
        if (!modelBriefing.isEmpty()) {
            for (int i = 0; i < modelBriefing.size(); i++) {
                if (!enable) break;
                if (modelBriefing.get(i).getNav() == null) {enable = false; break;}
                if (!modelBriefing.get(i).getObjectives().isEmpty()) {
                    for (int i2 = 0; i2 < modelBriefing.get(i).getObjectives().size(); i2++) {
                        if (modelBriefing.get(i).getObjectives().get(i2).getDescription() == null) {
                            enable = false;
                            break;
                        }
                    }
                }
            }
        } else {
            enable = false;
        }
        return enable;
    }
    
    public void exportEnable() {
        prepareTemplate.getBtnExport().setEnabled(isExportEnable());
    }

    public void startExport() {
        File container = new File("Missions Briefings/" + modelConfigurations.getTopSecret().getOperationName());
        if (!container.exists()) {
            container.mkdirs();
            exportTemplate(container);
            File subContainer = new File(container, "src");
            subContainer.mkdirs();
            exportStrings(subContainer);
            exportImages(subContainer);
            JOptionPane.showMessageDialog(prepareTemplate.getView(), "Briefing was created successful.\nCarpet: Missions Briefings/" + modelConfigurations.getTopSecret().getOperationName(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(prepareTemplate.getView(), "A folder with that name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void exportTemplate(File container) {
        try {
            File file = new File(container, modelConfigurations.getTopSecret().getOperationName() + ".html");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            templates.TemplatesManager templatesManager = new TemplatesManager();
            InputStream template = templatesManager.getUnitedStatesGovernment();
            Scanner scanner = new Scanner(template);
            while (scanner.hasNextLine()) {
                printWriter.println(scanner.nextLine());
            }
            template.close();
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
    
    private void exportStrings(File container) {
        try {
            File file = new File(container, "string.js");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            // create string
            String str = "const strings = {\n";
                // Login
                str += "login: {\n";
                    str += "\ttitle: '" + modelConfigurations.getLoginForm().getTitle() + "',\n";
                    str += "\tbtnLoginTag: '" + modelConfigurations.getLoginForm().getBtnLoginTag() + "',\n";
                    str += "\tbtnSkipToPanel: '" + modelConfigurations.getLoginForm().getBtnSkipToPanel() + "',\n";
                    str += "\tuser: '" + modelConfigurations.getLoginForm().getUser() + "',\n";
                    str += "\tpass: '" + modelConfigurations.getLoginForm().getPass() + "'\n";
                str += "},\n";
                // Top secret
                str += "topSecret: {\n";
                    str += "\ttag: '" + modelConfigurations.getTopSecret().getTag() + "',\n";
                    str += "\toperationName: '" + modelConfigurations.getTopSecret().getOperationName()+ "'\n";
                str += "},\n";
                // Web Tag
                str += "header: {\n";
                    str += "\ttitle: '" + modelConfigurations.getWebTags().getHeaderTitle() + "',\n";
                    str += "\tsubTitle: '" + modelConfigurations.getWebTags().getHeaderSubTitle() + "'\n";
                str += "},\n";
                str += "panel: {\n";
                    str += "\tobjectivesTag: '" + modelConfigurations.getWebTags().getPanelObjectiveTag() + "'\n";
                str += "},\n";
                // Web config
                str += "webConfig: {\n";
                    str += "\tnavSize: " + modelConfigurations.getNavSize() + ",\n";
                    str += "\theightMapImages: [";
                    for (int i = 0; i < modelBriefing.size(); i++) {
                        if (i != 0) str += ", ";
                        str += String.valueOf(modelBriefing.get(i).getHeightMapImages());
                    }
                    str += "],\n";
                    str += "\tbackgroundColor: {\n";
                        str += "\t\ttop: '" + modelConfigurations.getBackgroundColorTop().getRed() + "," + modelConfigurations.getBackgroundColorTop().getGreen() + "," + modelConfigurations.getBackgroundColorTop().getBlue() + "," + modelConfigurations.getBackgroundColorTop().getAlpha() + "',\n";
                        str += "\t\tbottom: '" + modelConfigurations.getBackgroundColorBottom().getRed() + "," + modelConfigurations.getBackgroundColorBottom().getGreen() + "," + modelConfigurations.getBackgroundColorBottom().getBlue() + "," + modelConfigurations.getBackgroundColorBottom().getAlpha() + "'\n";
                    str += "\t}\n";
                str += "},\n";
                // briefing
                str += "debrief: [\n";
                for (int i = 0; i < modelBriefing.size(); i++) {
                    str += "\t{\n";
                        str += "\t\tnav: '" + modelBriefing.get(i).getNav() + "'";
                        if (modelBriefing.get(i).getTitle() != null) str += ",\n\t\ttitle: '" + modelBriefing.get(i).getTitle()+ "'";
                        if (modelBriefing.get(i).getDescription().getTime() != null ||
                            modelBriefing.get(i).getDescription().getReceiver()!= null ||
                            modelBriefing.get(i).getDescription().getSender()!= null ||
                            modelBriefing.get(i).getDescription().getDescription()!= null
                        ) {
                            str += ",\n\t\tdescription: '";
                                if (modelBriefing.get(i).getDescription().getTime() != null) str += "<b><i>Tiempo:</i></b> " + modelBriefing.get(i).getDescription().getTime() + "<br>";
                                if (modelBriefing.get(i).getDescription().getReceiver() != null) str += "<b><i>Dirigido a:</i></b> " + modelBriefing.get(i).getDescription().getReceiver() + "<br>";
                                if (modelBriefing.get(i).getDescription().getSender() != null) str += "<b><i>Enviado por:</i></b> " + modelBriefing.get(i).getDescription().getSender() + "<br>";
                                if (modelBriefing.get(i).getDescription().getDescription() != null) str += modelBriefing.get(i).getDescription().getDescription();
                            str += "'";
                        }
                        if (modelBriefing.get(i).getMap() != null) {
                            str += ",\n\t\tmap: 'src/img/breafing_" + i + "." + getFileExtension(modelBriefing.get(i).getMap()) + "'";
                        }
                        // objective
                        if (!modelBriefing.get(i).getObjectives().isEmpty()) {
                            str += ",\n\t\tobjectives: [\n";
                            for (int i2 = 0; i2 < modelBriefing.get(i).getObjectives().size(); i2++) {
                                str += "\t\t\t{\n";
                                    str += "\t\t\t\tdescription: '" + modelBriefing.get(i).getObjectives().get(i2).getDescription() + "'";
                                    if (!modelBriefing.get(i).getObjectives().get(i2).getImages().isEmpty()) {
                                        str += ",\n\t\t\t\timages: [\n";
                                        for (int i3 = 0; i3 < modelBriefing.get(i).getObjectives().get(i2).getImages().size(); i3++) {
                                            str += "\t\t\t\t\t'src/img/objective_" + i + "_" + i3 + "." + getFileExtension(modelBriefing.get(i).getObjectives().get(i2).getImages().get(i3)) + "'";
                                            if (i3 == modelBriefing.get(i).getObjectives().get(i2).getImages().size() - 1) {str += "\n";} else {str += ",\n";}
                                        }
                                        str += "\t\t\t\t]";
                                    }
                                if (i2 == modelBriefing.get(i).getObjectives().size() - 1) {str += "\n\t\t\t}\n";} else {str += "\n\t\t\t},\n";}
                            }
                            str += "\t\t]";
                        }
                    if (i == modelBriefing.size() - 1) {str+="\n\t}\n";} else {str += "\n\t},\n";}
                }
                str += "]\n";
            printWriter.print(str + "};");
            // end to create string
            printWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
    
    private void exportImages(File container) {
        File newContainer = new File(container, "img");
        File copy = null;
        newContainer.mkdirs();
        for (int i = 0; i < modelBriefing.size(); i++) {
            if (modelBriefing.get(i).getMap() != null) {
                copy = new File(newContainer, "breafing_" + i + "." + getFileExtension(modelBriefing.get(i).getMap()));
                try {
                    copy.createNewFile();
                    copyFile(modelBriefing.get(i).getMap(), copy);
                } catch (IOException ex) {
                    System.err.println(ex.toString());
                }
            }
            for (int i2 = 0; i2 < modelBriefing.get(i).getObjectives().size(); i2++) {
                for (int i3 = 0; i3 < modelBriefing.get(i).getObjectives().get(i2).getImages().size(); i3++) {
                    if (modelBriefing.get(i).getObjectives().get(i2).getImages().get(i3) != null) {
                        copy = new File(newContainer, "objective_" + i + "_" + i3 + "." + getFileExtension(modelBriefing.get(i).getObjectives().get(i2).getImages().get(i3)));
                        try {
                            copy.createNewFile();
                            copyFile(modelBriefing.get(i).getMap(), copy);
                        } catch (IOException ex) {
                            System.err.println(ex.toString());
                        }
                    }
                }
            }
        }
        try {
            InputStream imageLogo = new TemplatesManager().getLogoImage();
            FileOutputStream outputStream = new FileOutputStream(new File(container, "img/logo.png"));
            int i = 0;
            while((i=imageLogo.read())!=-1){
                outputStream.write(i);
           }
        } catch (IOException ex) {
        }
    }
    
    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
    private void copyFile(File origin, File copy) {
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream = new FileInputStream(origin);
            fileOutputStream = new FileOutputStream(copy);
           int i=0;
           while((i=fileInputStream.read())!=-1){
                fileOutputStream.write(i);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fileInputStream=null;
            fileOutputStream=null;
        }
    }
}
