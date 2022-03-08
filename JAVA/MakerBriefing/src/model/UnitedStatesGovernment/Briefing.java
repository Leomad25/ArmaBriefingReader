package model.UnitedStatesGovernment;

import java.io.File;
import java.util.ArrayList;

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

/**
 *
 * @author Leonardo Miguel Aguado Diaz
 */
public class Briefing {
    private String 
            nav = null,
            title = null;
    private File map = null;
    private Description description = new Description();
    private int heightMapImages = 0;
    private ArrayList<Objetive> objetives = new ArrayList<Objetive>();
    
    public Objetive createObjetive() {
        return new Objetive();
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getMap() {
        return map;
    }

    public void setMap(File map) {
        this.map = map;
    }

    public Description getDescription() {
        return description;
    }

    public int getHeightMapImages() {
        return heightMapImages;
    }

    public void setHeightMapImages(int heightMapImages) {
        this.heightMapImages = heightMapImages;
    }

    public void addObjetives(Objetive obj) {
        objetives.add(obj);
    }
    
    public class Objetive {
        private String description = null;
        private ArrayList<File> images = new ArrayList<File>();

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ArrayList<File> getImages() {
            return images;
        }

        public void addImages(File file) {
            images.add(file);
        }
    }
    
    public class Description {
        private String time = null;
        private String receiver = null;
        private String sender = null;
        private String description = null;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
