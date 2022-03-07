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
package model.UnitedStatesGovernment;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class Configurations {
    private final LoginForm loginForm = new LoginForm();
    private final TopSecret topSecret = new TopSecret();
    private final WebTags webTags = new WebTags();
    private int navSize = 90;
    private final rgbColor backgroundColorTop = new rgbColor();
    private final rgbColor backgroundColorBottom = new rgbColor();

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public TopSecret getTopSecret() {
        return topSecret;
    }

    public WebTags getWebTags() {
        return webTags;
    }

    public int getNavSize() {
        return navSize;
    }

    public void setNavSize(int navSize) {
        this.navSize = navSize;
    }

    public rgbColor getBackgroundColorTop() {
        return backgroundColorTop;
    }

    public rgbColor getBackgroundColorBottom() {
        return backgroundColorBottom;
    }
    
    private class rgbColor {
        private int red = 0;
        private int green = 0;
        private int blue = 0;
        private float alpha = 0;

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public int getBlue() {
            return blue;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }

        public float getAlpha() {
            return alpha;
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
        }
        
        @Override
        public String toString() {
            return red + "," + green + "," + blue + "," + alpha;
        }
    }
    
    private class LoginForm {
        private String title, btnLoginTag, btnSkipToPanel, user, pass;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBtnLoginTag() {
            return btnLoginTag;
        }

        public void setBtnLoginTag(String btnLoginTag) {
            this.btnLoginTag = btnLoginTag;
        }

        public String getBtnSkipToPanel() {
            return btnSkipToPanel;
        }

        public void setBtnSkipToPanel(String btnSkipToPanel) {
            this.btnSkipToPanel = btnSkipToPanel;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }
    
    private class TopSecret {
        private String tag, operationName;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getOperationName() {
            return operationName;
        }

        public void setOperationName(String operationName) {
            this.operationName = operationName;
        }
    }
    
    private class WebTags {
        private String headerTitle, headerSubTitle, panelObjectiveTag;

        public String getHeaderTitle() {
            return headerTitle;
        }

        public void setHeaderTitle(String headerTitle) {
            this.headerTitle = headerTitle;
        }

        public String getHeaderSubTitle() {
            return headerSubTitle;
        }

        public void setHeaderSubTitle(String headerSubTitle) {
            this.headerSubTitle = headerSubTitle;
        }

        public String getPanelObjectiveTag() {
            return panelObjectiveTag;
        }

        public void setPanelObjectiveTag(String panelObjectiveTag) {
            this.panelObjectiveTag = panelObjectiveTag;
        }
    }
}

