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
package model;

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class Configs {
    private int navSize;
    private rgbColor top, bottom;

    public int getNavSize() {
        return navSize;
    }

    public void setNavSize(int navSize) {
        this.navSize = navSize;
    }

    public String getTop() {
        return top.toString();
    }

    public void setTop(int red, int green, int blue, int alpha) {
        top.setRed(red);
        top.setGreen(green);
        top.setBlue(blue);
        top.setAlpha(alpha);
    }

    public String getBottom() {
        return bottom.toString();
    }

    public void setBottom(int red, int green, int blue, int alpha) {
        bottom.setRed(red);
        bottom.setGreen(green);
        bottom.setBlue(blue);
        bottom.setAlpha(alpha);
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
}

