package model.UnitedStatesGovernment;

import java.util.List;

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
    private String nav, title, description, map;
    private int heightMapImages = 720;
    private List<Objetive> objetives = null;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getHeightMapImages() {
        return heightMapImages;
    }

    public void setHeightMapImages(int heightMapImages) {
        this.heightMapImages = heightMapImages;
    }

    public List<Objetive> getObjetives() {
        return objetives;
    }

    public void setObjetives(Objetive objetive) {
        objetives.add(objetive);
    }
    
    public Objetive createObjetive() {
        return new Objetive();
    }
    
    public class Objetive {
        private String description;
        private List<String> images = null;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getImages() {
            return images;
        }

        public void addImages(String route) {
            images.add(route);
        }
    }
}
