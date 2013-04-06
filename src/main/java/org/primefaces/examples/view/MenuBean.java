/*
 * Copyright 2009-2012 Prime Teknoloji.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.examples.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuitem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

public class MenuBean {

	private MenuModel model;

	public MenuBean() {
		model = new DefaultMenuModel();
		
		//First submenu
        DefaultSubMenu submenu = new DefaultSubMenu("Dynamic Submenu 1");
		
        DefaultMenuitem item = new DefaultMenuitem("Dynamic Menuitem 1.1");
		item.setUrl("#");
		submenu.addElement(item);
		
		model.addSubmenu(submenu);
		
		//Second submenu
		submenu = new DefaultSubMenu("Dynamic Submenu 2");
		
		item = new DefaultMenuitem("Dynamic Menuitem 2.1");
		item.setUrl("#");
		submenu.addElement(item);
		
		item = new DefaultMenuitem("Dynamic Menuitem 2.2");
		item.setUrl("#");
		submenu.addElement(item);
		
		model.addSubmenu(submenu);
	}

	public MenuModel getModel() {
		return model;
	}	
    
    public void save() {
		addMessage("Data saved");
	}
	
	public void update() {
		addMessage("Data updated");
	}
	
	public void delete() {
		addMessage("Data deleted");
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}