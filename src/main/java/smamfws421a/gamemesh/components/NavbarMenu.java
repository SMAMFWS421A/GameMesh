package smamfws421a.gamemesh.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import smamfws421a.gamemesh.security.SecurityService;

@Component
public class NavbarMenu {
    
    private final SecurityService securityService;

    @Getter
    private final MenuBar menu = new MenuBar();


    public NavbarMenu(SecurityService securityService){
        this.securityService = securityService;

        menu.addThemeVariants(MenuBarVariant.LUMO_END_ALIGNED); //how to align a fkn menu properly
        MenuItem menuItem = menu.addItem(VaadinIcon.MENU.create());
        SubMenu subUserMenu = menuItem.getSubMenu();

        //Profile
        MenuItem profileButton = subUserMenu.addItem(VaadinIcon.USER.create());
        profileButton.add("Profile Record");
        //ComponentEventListener<ClickEvent<MenuItem>> listener = e -> ;
        //profileButton.addClickListener(listener);


        //logout
        MenuItem logoutButton = subUserMenu.addItem(VaadinIcon.EXIT.create());
        logoutButton.add("Sign Out");

        //mental instability
        ComponentEventListener<ClickEvent<MenuItem>> logoutListener = e -> securityService.logout();
        logoutButton.addClickListener(logoutListener);

    }


}
